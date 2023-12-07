package com.sephiraandy.day7;

import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

import static com.sephiraandy.util.Input.lineStream;

public class Day7 extends Puzzle<Long> {
    public Day7(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public Long solve1(String input) {
        final var handBids = lineStream(input)
            .map(HandBid::parseWithJacks)
            .sorted()
            .toList();

        var sum = 0L;
        for (int i = 0; i < handBids.size(); ++i) {
            sum += (i + 1) * handBids.get(i).bid();
        }
        return sum;
    }

    @Override
    public Long solve2(String input) {
        final var handBids = lineStream(input)
            .map(HandBid::parseWithJokers)
            .sorted()
            .toList();

        var sum = 0L;
        for (int i = 0; i < handBids.size(); ++i) {
            sum += (i + 1) * handBids.get(i).bid();
        }
        return sum;
    }
}
