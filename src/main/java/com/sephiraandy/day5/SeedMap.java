package com.sephiraandy.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
        final var unresolved = new ArrayDeque<SeedRange>();
        unresolved.add(input);
        final var output = new ArrayList<SeedRange>();

        while (!unresolved.isEmpty()) {
            final var range = unresolved.remove();
            if (filter(range, output, unresolved)) {
                output.add(range);
            }
        }

        return output;
    }

    private boolean filter(SeedRange range, ArrayList<SeedRange> output, ArrayDeque<SeedRange> unresolved) {
        var passed = true;
        for (var seedMapData : seedMapData) {
            passed = filter(seedMapData, range, output, unresolved, passed);
            if (!passed) {
                break;
            }
        }
        return passed;
    }

    private static boolean filter(SeedMapData seedMapData, SeedRange range, ArrayList<SeedRange> output, ArrayDeque<SeedRange> unresolved, boolean passed) {
        if (seedMapData.isInRange(range.start())) {
            if (seedMapData.isInRange(range.last())) {
                output.add(new SeedRange(seedMapData.map(range.start()), range.range()));
                return false;
            }

            final var intersect = seedMapData.upper();
            output.add(new SeedRange(seedMapData.map(range.start()), intersect - range.start()));
            unresolved.add(new SeedRange(intersect, range.upper() - intersect));
            return false;
        }

        if (seedMapData.isInRange(range.last())) {
            output.add(new SeedRange(seedMapData.destinationRangeStart(), range.last() - seedMapData.sourceRangeStart()));
            unresolved.add(new SeedRange(range.start(), seedMapData.sourceRangeStart() - range.start()));
            return false;
        }

        if (!seedMapData.isUnderRange(range.last()) && seedMapData.isUnderRange(range.start())) {
            final var intersect = seedMapData.upper();
            output.add(new SeedRange(seedMapData.destinationRangeStart(), seedMapData.rangeLength()));
            unresolved.add(new SeedRange(range.start(), seedMapData.sourceRangeStart() - range.start()));
            unresolved.add(new SeedRange(intersect, range.upper() - intersect));
            return false;
        }

        return passed;
    }
}
