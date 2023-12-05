package com.sephiraandy.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

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

    public LongStream pairStream() {

        var stream = LongStream.empty();

        for (var seedPairStart = 0; seedPairStart < seedList.size(); seedPairStart += 2) {
            final var start = seedList.get(seedPairStart);
            final var range = seedList.get(seedPairStart + 1);
            stream = LongStream.concat(stream, LongStream.range(start, start + range));
        }

        return stream.parallel();
    }
}