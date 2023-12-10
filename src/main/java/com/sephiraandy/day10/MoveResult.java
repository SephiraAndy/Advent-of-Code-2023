package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public record MoveResult(boolean invalid,
                         boolean complete,
                         Move next,
                         GridVector direction) {

    public static @NotNull MoveResult invalidMove() {
        return new MoveResult(true, false, null, null);
    }

    public static @NotNull MoveResult complete(GridVector direction) {
        return new MoveResult(false, true, null, direction);
    }

    public static @NotNull MoveResult continues(Move next) {
        return new MoveResult(false, false, next, null);
    }
}
