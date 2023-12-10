package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.GridVector.*;
import static com.sephiraandy.util.Input.asLines;

public class PipeMap {
    private static final int DYNAMIC_PATH = 1;
    private static final int DYNAMIC_EMPTY = 0;
    private static final int DYNAMIC_OUTSIDE = 2;
    private final PipeMapTile[][] map;
    private final GridVector start;

    private PipeMap(final @NotNull GridVector start,
                    final @NotNull PipeMapTile[][] map) {
        this.start = start;
        this.map = map;
    }

    public static @NotNull PipeMap parse(final @NotNull String input) {
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

        return new PipeMap(start, map);
    }

    public @NotNull LoopResult findLoop() {

        var initialDirections = new GridVector[]{
            RIGHT,
            DOWN,
            LEFT,
            UP
        };

        for (var initialDirection : initialDirections) {
            var validMove = move(new Move(start, start.translate(initialDirection)));
            var pathLength = 0;

            final var dynamicMap = new int[map.length][map[0].length];
            dynamicMap[start.y()][start.x()] = DYNAMIC_PATH;

            while (!validMove.isInvalid()) {
                ++pathLength;
                if (validMove.isComplete()) {
                    map[start.y()][start.x()] = createMapTile(validMove.direction(), initialDirection);
                    return new LoopResult(pathLength, calculateArea(dynamicMap));
                }
                dynamicMap[validMove.next().position().y()][validMove.next().position().x()] = DYNAMIC_PATH;
                validMove = move(validMove.next());
            }
        }

        return new LoopResult(0, 0);
    }

    private int calculateArea(final int @NotNull[] @NotNull[] dynamicMap) {
        var count = 0;
        for (var rowIndex = 0; rowIndex < dynamicMap.length; ++rowIndex) {
            PipeMapTile cornerStart = null;
            var isOutside = true;
            final var rowLength = dynamicMap[rowIndex].length;
            for (var columnIndex = 0; columnIndex < rowLength; ++columnIndex) {
                if (dynamicMap[rowIndex][columnIndex] == DYNAMIC_EMPTY) {
                    if (!isOutside) {
                        ++count;
                    }
                    continue;
                }

                final var pipeMapTile = map[rowIndex][columnIndex];
                if (pipeMapTile.isHorizontal()) {
                    continue;
                }

                if (pipeMapTile.isVertical()) {
                    isOutside = !isOutside;
                    continue;
                }

                if (cornerStart == null) {
                    cornerStart = pipeMapTile;
                    continue;
                }

                isOutside = handleInOut(cornerStart, pipeMapTile, isOutside);
                cornerStart = null;
            }

        }
        return count;
    }

    private boolean handleInOut(final @NotNull PipeMapTile start,
                                final @NotNull PipeMapTile end,
                                final boolean isOutside) {
        return (start.polarity() == end.polarity()) ? !isOutside : isOutside;
    }

    private @NotNull PipeMapTile createMapTile(final @NotNull GridVector entry,
                                               final @NotNull GridVector exit) {
        if (entry.equals(RIGHT)) {
            if (exit.equals(RIGHT)) return createMapTile('-');
            if (exit.equals(UP)) return createMapTile('J');
            if (exit.equals(DOWN)) return createMapTile('7');
        } else if (entry.equals(DOWN)) {
            if (exit.equals(DOWN)) return createMapTile('|');
            if (exit.equals(RIGHT)) return createMapTile('L');
            if (exit.equals(LEFT)) return createMapTile('J');
        } else if (entry.equals(LEFT)) {
            if (exit.equals(LEFT)) return createMapTile('-');
            if (exit.equals(UP)) return createMapTile('L');
            if (exit.equals(DOWN)) return createMapTile('F');
        } else if (entry.equals(UP)) {
            if (exit.equals(UP)) return createMapTile('|');
            if (exit.equals(RIGHT)) return createMapTile('F');
            if (exit.equals(LEFT)) return createMapTile('7');
        }

        throw new RuntimeException("Cannot exit and leave the same side.");
    }

    private @NotNull MoveResult move(final @NotNull Move move) {
        final var next = move.next();
        if (next.x() < 0 || next.y() < 0 || next.x() >= map[0].length || next.y() >= map.length) {
            return MoveResult.invalidMove();
        }
        final var delta = move.delta();
        return getTileAt(next).move(delta, next);
    }

    private static @NotNull PipeMapTile createMapTile(final @NotNull Character rawValue) {
        return switch (rawValue) {
            case '-' -> new PipeSection(RIGHT, RIGHT, LEFT, LEFT);
            case '7' -> new PipeSection(RIGHT, DOWN, UP, LEFT);
            case '|' -> new PipeSection(UP, UP, DOWN, DOWN);
            case 'L' -> new PipeSection(DOWN, RIGHT, LEFT, UP);
            case 'J' -> new PipeSection(RIGHT, UP, DOWN, LEFT);
            case 'F' -> new PipeSection(UP, RIGHT, LEFT, DOWN);
            case 'S' -> new StartTile();
            case '.' -> new GroundTile();
            default -> throw new RuntimeException("Unknown tile raw value " + rawValue);
        };
    }

    private @NotNull PipeMapTile getTileAt(final @NotNull GridVector position) {
        return map[position.y()][position.x()];
    }

}
