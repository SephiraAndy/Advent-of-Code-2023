package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public interface PipeMapTile {
    @NotNull MoveResult move(@NotNull GridVector delta, GridVector next);

    boolean isHorizontal();

    boolean isVertical();

    boolean polarity();
}
