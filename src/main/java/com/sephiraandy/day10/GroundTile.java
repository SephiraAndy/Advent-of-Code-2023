package com.sephiraandy.day10;

public class GroundTile implements PipeMapTile {
    @Override
    public MoveResult move(GridVector delta, GridVector next) {
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
