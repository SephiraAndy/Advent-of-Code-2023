package com.sephiraandy.day8;

import java.util.Map;

public class Destinations {

    private Map<Character, String> destinations;

    private Destinations() {

    }

    public static Destinations parse(String raw) {
        final var rawLeftAndRight = raw.substring(1, raw.length() - 1).split(", ");
        final var destinations = new Destinations();
        destinations.destinations = Map.of('L', rawLeftAndRight[0], 'R', rawLeftAndRight[1]);
        return destinations;
    }

    public String next(char instruction) {
        return destinations.get(instruction);
    }
}
