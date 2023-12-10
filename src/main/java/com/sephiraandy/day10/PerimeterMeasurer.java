package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

class PerimeterMeasurer {
    private int perimeter;

    public void init(final GridVector ignored) {
        perimeter = 0;
    }

    public void preUpdate() {
        ++perimeter;
    }

    public int onComplete(final @NotNull MoveResult ignored) {
        return perimeter;
    }
}
