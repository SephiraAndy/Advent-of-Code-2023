package com.sephiraandy.day10;

public record MoveResult(boolean invalid, boolean complete, Move next, GridVector direction) {

    public static MoveResult invalidMove() {
        return new MoveResult(true, false, null, null);
    }

    public static MoveResult complete(GridVector direction) {
        return new MoveResult(false, true, null, direction);
    }

    public static MoveResult continues(Move next) {
        return new MoveResult(false, false, next, null);
    }
}
