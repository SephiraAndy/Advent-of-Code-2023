package com.sephiraandy.day3;

import com.sephiraandy.util.Input;

import java.io.IOException;

public class Day3 {
    public static int solve1(final String input) {
        return EngineSchematic.parse(input)
            .getPartNumbers()
            .stream()
            .reduce(0, Integer::sum);
    }

    public static int solve2(final String input) {
        return EngineSchematic.parse(input)
            .getGears()
            .stream()
            .mapToInt(Gear::ratio)
            .sum();
    }

    public static void main(final String[] args) throws IOException {
        final var input = Input.loadTextFromFile("input/Day3");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }
}
