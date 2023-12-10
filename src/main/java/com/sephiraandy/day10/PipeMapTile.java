package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.GridVector.*;

public interface PipeMapTile {
    @NotNull MoveResult move(@NotNull GridVector delta, GridVector next);

    boolean isHorizontal();

    boolean isVertical();

    boolean polarity();

    static @NotNull PipeMapTile createMapTile(final @NotNull Character rawValue) {
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

    static @NotNull PipeMapTile createMapTile(final @NotNull GridVector entry,
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
}
