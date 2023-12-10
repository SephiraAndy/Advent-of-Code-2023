package com.sephiraandy.day3;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day3 extends Puzzle<Integer> {
    public Day3(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public @NotNull Integer solve1(final @NotNull String input) {
        return EngineSchematic.parse(input)
            .getPartNumbers()
            .stream()
            .reduce(0, Integer::sum);
    }

    public @NotNull Integer solve2(final @NotNull String input) {
        return EngineSchematic.parse(input)
            .getGears()
            .stream()
            .mapToInt(Gear::ratio)
            .sum();
    }
}
