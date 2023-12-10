package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

public record Move(@NotNull GridVector position, @NotNull GridVector next) {
    public @NotNull GridVector delta() {
        return new GridVector(next.x() - position.x(), next.y() - position.y());
    }
}
