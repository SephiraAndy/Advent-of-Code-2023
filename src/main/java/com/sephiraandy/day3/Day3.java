package com.sephiraandy.day3;

import com.sephiraandy.util.Puzzle;

import java.io.IOException;
import java.util.function.Consumer;

public class Day3 extends Puzzle<Integer> {
    public Day3(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

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

    public static void main(final String[] args) {
        new Day3(System.out::print).solve("input/Day3");
    }
}
