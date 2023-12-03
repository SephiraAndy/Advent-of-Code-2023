package com.sephiraandy.day3;

public class Gear {
    private final int partNumberA;
    private final int partNumberB;

    public Gear(int partNumberA, int partNumberB) {
        this.partNumberA = partNumberA;
        this.partNumberB = partNumberB;
    }

    public int ratio() {
        return partNumberA * partNumberB;
    }
}
