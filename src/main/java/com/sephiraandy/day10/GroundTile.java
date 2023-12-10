package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public class GroundTile implements PipeMapTile {
    @Override
    public @NotNull MoveResult move(final @NotNull GridVector delta, GridVector next) {
        return MoveResult.invalidMove();
    }

    @Override
    public boolean isHorizontal() {
        return false;
    }

    @Override
    public boolean isVertical() {
        return false;
    }

    @Override
    public boolean polarity() {
        return false;
    }
}
