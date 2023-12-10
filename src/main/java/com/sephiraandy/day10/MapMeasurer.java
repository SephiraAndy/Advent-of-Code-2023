package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public interface MapMeasurer {
    void init(@NotNull GridVector initialDirection);

    void preUpdate();

    void postUpdate(@NotNull GridVector position);

    int onComplete(@NotNull MoveResult validMove);
}
