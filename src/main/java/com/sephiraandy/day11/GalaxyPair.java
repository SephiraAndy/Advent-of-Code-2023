package com.sephiraandy.day11;

public record GalaxyPair(CosmosVector lowest, CosmosVector highest) {
    public static GalaxyPair of(CosmosVector galaxy1, CosmosVector galaxy2) {
        if (galaxy1.isLowerThan(galaxy2)) {
            return new GalaxyPair(galaxy1, galaxy2);
        }
        return new GalaxyPair(galaxy2, galaxy1);
    }

    public long distance() {
        return Math.abs(highest.y() - lowest.y()) + Math.abs(highest.x() - lowest.x());
    }
}
