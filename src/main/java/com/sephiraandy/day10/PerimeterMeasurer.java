package com.sephiraandy.day10;

class PerimeterMeasurer {
    private int perimeter;

    public void init(final GridVector ignored) {
        perimeter = 0;
    }

    public void preUpdate() {
        ++perimeter;
    }

    public int perimeter() {
        return perimeter;
    }
}
