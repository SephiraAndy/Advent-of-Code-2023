package com.sephiraandy.day10;

public class StartTile implements PipeMapTile {
    @Override
    public MoveResult move(GridVector delta, GridVector next) {
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
