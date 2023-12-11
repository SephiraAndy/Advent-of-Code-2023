package com.sephiraandy.day11;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Cosmos {
    private final ArrayList<CosmosVector> galaxies;

    Cosmos(final @NotNull ArrayList<CosmosVector> galaxies) {
        this.galaxies = galaxies;
    }

    public long sumDistances() {
        return IntStream.range(0, galaxies.size())
            .mapToLong(galaxy1Index -> IntStream.range(galaxy1Index + 1, galaxies.size())
                .mapToObj(galaxy2Index -> new GalaxyPair(galaxies.get(galaxy1Index), galaxies.get(galaxy2Index)))
                .mapToLong(GalaxyPair::distance).sum()).sum();
    }
}
