package com.sephiraandy.day11;

import org.jetbrains.annotations.NotNull;

public record GalaxyPair(@NotNull CosmosVector lowest,
                         @NotNull CosmosVector highest) {
    public long distance() {
        return Math.abs(highest.y() - lowest.y()) + Math.abs(highest.x() - lowest.x());
    }
}
