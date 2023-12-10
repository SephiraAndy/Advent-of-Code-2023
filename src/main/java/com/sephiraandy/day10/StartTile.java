package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public class StartTile implements PipeMapTile {
    @Override
    public @NotNull MoveResult move(@NotNull GridVector delta, GridVector next) {
        return MoveResult.complete(delta);
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
