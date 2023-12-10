package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.sephiraandy.day10.GridVector.*;
import static com.sephiraandy.day10.PipeMapTile.createMapTile;
import static com.sephiraandy.util.Input.asLines;

public class PipeMap {
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

    public int enclosedArea() {
        final var areaMeasurer = new AreaMeasurer(this);
        return evaluate(areaMeasurer::init, () -> {}, areaMeasurer::postUpdate, areaMeasurer::onComplete);
    }

    public int perimeter() {
        final var perimeterMeasurer = new PerimeterMeasurer();
        return evaluate(perimeterMeasurer::init, perimeterMeasurer::preUpdate, r -> {}, perimeterMeasurer::onComplete);
    }

    public int evaluate(final @NotNull Consumer<GridVector> init,
                         final @NotNull Runnable preUpdate,
                         final @NotNull Consumer<GridVector> postUpdate,
                         final @NotNull Function<MoveResult, Integer> onComplete) {
        for (var initialDirection : INITIAL_DIRECTIONS) {
            var validMove = move(new Move(start, start.translate(initialDirection)));
            init.accept(initialDirection);
            while (!validMove.invalid()) {
                preUpdate.run();
                if (validMove.complete()) {
                    return onComplete.apply(validMove);
                }
                postUpdate.accept(validMove.next().position());
                validMove = move(validMove.next());
            }
        }
        return 0;
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
