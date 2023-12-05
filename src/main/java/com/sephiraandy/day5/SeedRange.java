package com.sephiraandy.day5;

public record SeedRange(long start, long range) {
    public long last() {
        return upper() - 1;
    }

    public long upper() {
        return start + range;
    }
}
