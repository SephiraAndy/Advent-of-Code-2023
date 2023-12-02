package com.sephiraandy.day2;

record CubeSet(int red, int green, int blue) {
    int power() {
        return red * green * blue;
    }
}
