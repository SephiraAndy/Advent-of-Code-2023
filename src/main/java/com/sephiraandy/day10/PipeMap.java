package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static com.sephiraandy.day10.GridVector.*;
import static com.sephiraandy.day10.PipeMapTile.createMapTile;
import static com.sephiraandy.util.Input.asLines;

public class PipeMap implements PipeTileContainer {
    public static final GridVector[] INITIAL_DIRECTIONS = new GridVector[]{
        RIGHT,
        DOWN,
        LEFT,
        UP
    };
    private final @NotNull PipeMapTile[][] map;
    private final @NotNull GridVector start;

    private PipeMap(final @NotNull GridVector start,
                    final @NotNull PipeMapTile[][] map) {
        this.start = start;
        this.map = map;
    }

    public static @NotNull Optional<PipeMap> parse(final @NotNull String input) {
        final var rows = asLines(input);
        final var map = new PipeMapTile[rows.length][rows[0].length()];
        GridVector start = null;

        for (var rowIndex = 0; rowIndex < rows.length; ++rowIndex) {
            for (var columnIndex = 0; columnIndex < rows[0].length(); ++columnIndex) {
                final var tileCharacter = rows[rowIndex].charAt(columnIndex);
                map[rowIndex][columnIndex] = createMapTile(tileCharacter);
                if (tileCharacter == 'S') {
                    start = new GridVector(columnIndex, rowIndex);
                }
            }
        }

        if (start == null) {
            return Optional.empty();
        }

        return Optional.of(new PipeMap(start, map));
    }

    public @NotNull GridVector start() {
        return start;
    }

    public Optional<Integer> evaluate(final @NotNull MapMeasurer evaluator) {
        for (var initialDirection : INITIAL_DIRECTIONS) {
            var validMove = move(new Move(start, start.translate(initialDirection)));
            evaluator.init(initialDirection);
            while (!validMove.invalid()) {
                evaluator.preUpdate();
                if (validMove.complete()) {
                    return Optional.of(evaluator.onComplete(validMove));
                }
                evaluator.postUpdate(validMove.next().position());
                validMove = move(validMove.next());
            }
        }
        return Optional.empty();
    }

    private @NotNull MoveResult move(final @NotNull Move move) {
        final var next = move.next();

        return next.isOutOfBounds(width(), height())
            ? MoveResult.invalidMove()
            : getTileAt(next).move(move.delta(), next);
    }

    public @NotNull PipeMapTile getTileAt(final @NotNull GridVector position) {
        return map[position.y()][position.x()];
    }

    public int height() {
        return map.length;
    }

    public int width() {
        return map[0].length;
    }
}
