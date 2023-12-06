package com.sephiraandy.day6;

import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

public class Day6 extends Puzzle<Long> {
    public Day6(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public Long solve1(final String input) {
        return Race.parseRaces(input).stream()
            .mapToLong(Race::numberOfWaysToBeat)
            .reduce(1, (a, b) -> a * b);
    }

    @Override
    public Long solve2(final String input) {
        return Race.parseRace(input).numberOfWaysToBeat();
    }
}
