package com.sephiraandy.day11;

public record CosmosVector(long x, long y) {
    public boolean isLowerThan(CosmosVector other) {
        if (x < other.x) {
            return true;
        }
        return x == other.x && y < other.y;
    }
}
