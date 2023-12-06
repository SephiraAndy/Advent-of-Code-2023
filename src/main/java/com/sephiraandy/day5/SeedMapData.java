package com.sephiraandy.day5;

import java.util.List;
import java.util.Optional;

public record SeedMapData(
    long destinationRangeStart,
    long sourceRangeStart,
    long rangeLength) {
    public static SeedMapData parse(String line) {
        final var rawData = line.split(" ");
        return new SeedMapData(Long.parseLong(rawData[0]), Long.parseLong(rawData[1]), Long.parseLong(rawData[2]));
    }

    public boolean isInRange(long seed) {
        return seed >= sourceRangeStart && seed < upper();
    }

    public long map(long seed) {
        return seed - sourceRangeStart + destinationRangeStart;
    }

    public long upper() {
        return sourceRangeStart + rangeLength;
    }

    public boolean isUnderRange(long seed) {
        return seed < sourceRangeStart;
    }

    public SeedRange map(SeedRange range) {
        return new SeedRange(map(range.start()), range.range());
    }

    public SeedRange destinationRange() {
        return new SeedRange(destinationRangeStart, rangeLength);
    }

    public Optional<FilterResult> filter(final SeedRange range) {
        if (isInRange(range.start())) {
            if (isInRange(range.last())) {
                return Optional.of(new FilterResult(map(range), List.of()));
            }

            final var intersect = upper();
            return Optional.of(new FilterResult(
                map(range.withRange(intersect - range.start())),
                List.of(new SeedRange(intersect, range.upper() - intersect))));
        }

        if (isInRange(range.last())) {
            return Optional.of(new FilterResult(
                new SeedRange(destinationRangeStart(), range.last() - sourceRangeStart()),
                List.of(new SeedRange(range.start(), sourceRangeStart() - range.start()))));
        }

        if (!isUnderRange(range.last()) && isUnderRange(range.start())) {
            final var intersect = upper();
            return Optional.of(new FilterResult(
                destinationRange(),
                List.of(
                    range.withRange(sourceRangeStart() - range.start()),
                    new SeedRange(intersect, range.upper() - intersect))));
        }

        return Optional.empty();
    }

    public record FilterResult(SeedRange output, List<SeedRange> unfiltered) {
    }
}
