package com.sephiraandy.day10;

public class MoveResult {
    private final boolean invalid;
    private final boolean complete;
    private final Move next;
    private final GridVector direction;

    public MoveResult(boolean invalid, boolean complete, Move next, GridVector direction) {
        this.invalid = invalid;
        this.complete = complete;
        this.next = next;
        this.direction = direction;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public boolean isComplete() {
        return complete;
    }

    public Move next() {
        return next;
    }
    public GridVector direction() { return direction; }

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
