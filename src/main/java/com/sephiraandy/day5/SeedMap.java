package com.sephiraandy.day5;

import java.util.*;

public class SeedMap {
    private final SeedMapData[] seedMapData;

    public SeedMap(final SeedMapData... seedMapData) {
        this.seedMapData = seedMapData;
    }

    public static SeedMap fetchData(final String[] lines,
                                    final String mapName) {
        for (int linePosition = 0; linePosition < lines.length; ++linePosition) {
            if (lines[linePosition].startsWith(mapName)) {
                final var seedMapDataList = new ArrayList<SeedMapData>();
                for (var dataLinePosition = linePosition + 1; dataLinePosition < lines.length; ++dataLinePosition) {
                    final var line = lines[dataLinePosition];
                    if (dataLinePosition == lines.length - 1 || line.isBlank()) {
                        return new SeedMap(seedMapDataList.toArray(new SeedMapData[0]));
                    }

                    seedMapDataList.add(SeedMapData.parse(line));
                }
            }
        }
        return new SeedMap();
    }

    public long map(final long seed) {
        for (var seedMapData : seedMapData) {
            if (seedMapData.isInRange(seed)) {
                return seedMapData.map(seed);
            }
        }
        return seed;
    }

    public List<SeedRange> map(final SeedRange input) {
        final var unfiltered = new ArrayDeque<SeedRange>();
        unfiltered.add(input);
        final var output = new ArrayList<SeedRange>();

        while (!unfiltered.isEmpty()) {
            final var range = unfiltered.remove();
            Arrays.stream(seedMapData)
                .map(smd -> smd.filter(range))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny()
                .ifPresentOrElse(filterResult -> {
                    unfiltered.addAll(filterResult.unfiltered());
                    output.add(filterResult.output());
                    },
                    () -> output.add(range));
        }

        return output;
    }
}
