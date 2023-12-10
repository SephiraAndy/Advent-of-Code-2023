package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public record GridVector(int x, int y) {
    public static final GridVector RIGHT = new GridVector(1, 0);
    public static final GridVector LEFT = new GridVector(-1, 0);
    public static final GridVector DOWN = new GridVector(0, 1);
    public static final GridVector UP = new GridVector(0, -1);

    public @NotNull GridVector translate(final @NotNull GridVector delta) {
        return new GridVector(x + delta.x, y + delta.y);
    }
}
