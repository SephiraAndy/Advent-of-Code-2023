package com.sephiraandy.day7;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.stream.IntStream;

import static com.sephiraandy.util.Input.lineStream;

public class Day7 extends Puzzle<Long> {
    public Day7(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Long solve1(@NotNull String input) {
        final var handBids = lineStream(input)
            .map(HandBid::parseWithJacks)
            .sorted()
            .toList();

        return IntStream.range(0, handBids.size())
            .mapToLong(i -> (i + 1) * handBids.get(i).bid())
            .sum();
    }

    @Override
    public @NotNull Long solve2(@NotNull String input) {
        final var handBids = lineStream(input)
            .map(HandBid::parseWithJokers)
            .sorted()
            .toList();

        return IntStream.range(0, handBids.size())
            .mapToLong(i -> (i + 1) * handBids.get(i).bid())
            .sum();
    }
}
