package com.sephiraandy.day3;

import com.sephiraandy.util.Puzzle;

import java.io.IOException;

public class Day3 extends Puzzle<Integer> {
    public Integer solve1(final String input) {
        return EngineSchematic.parse(input)
            .getPartNumbers()
            .stream()
            .reduce(0, Integer::sum);
    }

    public Integer solve2(final String input) {
        return EngineSchematic.parse(input)
            .getGears()
            .stream()
            .mapToInt(Gear::ratio)
            .sum();
    }

    public static void main(final String[] args) throws IOException {
        new Day3().solve("input/Day3");
    }
}
