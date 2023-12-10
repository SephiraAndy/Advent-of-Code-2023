package com.sephiraandy.day6;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day6 extends Puzzle<Long> {
    public Day6(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Long solve1(final @NotNull String input) {
        return Race.parseRaces(input).stream()
            .mapToLong(Race::numberOfWaysToBeat)
            .reduce(1, (a, b) -> a * b);
    }

    @Override
    public @NotNull Long solve2(final @NotNull String input) {
        return Race.parseRace(input).numberOfWaysToBeat();
    }
}
