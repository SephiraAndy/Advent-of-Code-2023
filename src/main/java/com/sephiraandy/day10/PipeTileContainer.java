package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public interface PipeTileContainer {
    int height();

    int width();

    GridVector start();

    PipeMapTile getTileAt(@NotNull GridVector currentPosition);
}
