package com.sephiraandy.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Seeds {

    private final List<Long> seedList;

    public Seeds(List<Long> seedList) {
        this.seedList = seedList;
    }

    public static Seeds parse(final String line) {
        final var seedList = new ArrayList<Long>();
        final var rawTitleAndData = line.split(":");
        final var rawData = rawTitleAndData[1].trim().split(" ");
        for (final var data : rawData) {
            seedList.add(Long.parseLong(data));
        }
        return new Seeds(seedList);
    }

    public LongStream stream() {
        return seedList.stream().mapToLong(Long::longValue);
    }

    public Stream<SeedRange> rangeStream() {
        final var ranges = new ArrayList<SeedRange>();
        for (var seedRangeStart = 0; seedRangeStart < seedList.size(); seedRangeStart += 2) {
            ranges.add(new SeedRange(seedList.get(seedRangeStart), seedList.get(seedRangeStart + 1)));
        }
        return ranges.stream();
    }
}
