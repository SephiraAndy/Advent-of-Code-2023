package com.sephiraandy.day10;

public interface PipeMapTile {
    MoveResult move(GridVector delta, GridVector next);

    boolean isHorizontal();

    boolean isVertical();

    boolean polarity();
}
