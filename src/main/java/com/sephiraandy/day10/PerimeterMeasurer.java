package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

class PerimeterMeasurer implements MapMeasurer{
    private int perimeter;

    @Override
    public void init(final @NotNull GridVector ignored) {
        perimeter = 0;
    }

    @Override
    public void preUpdate() {
        ++perimeter;
    }

    @Override
    public void postUpdate(final @NotNull GridVector position) {

    }

    @Override
    public int onComplete(final @NotNull MoveResult ignored) {
        return perimeter;
    }
}
