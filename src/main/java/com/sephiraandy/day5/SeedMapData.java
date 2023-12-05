package com.sephiraandy.day5;

public record SeedMapData(
    long destinationRangeStart,
    long sourceRangeStart,
    long rangeLength) {
    public static SeedMapData parse(String line) {
        final var rawData = line.split(" ");
        return new SeedMapData(Long.parseLong(rawData[0]), Long.parseLong(rawData[1]), Long.parseLong(rawData[2]));
    }

    public boolean isInRange(long seed) {
        return seed >= sourceRangeStart && seed < sourceRangeStart + rangeLength;
    }

    public long map(long seed) {
        return seed - sourceRangeStart + destinationRangeStart;
    }
}
