package com.sephiraandy.day11;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day11 extends Puzzle<Long> {

    public Day11() {
        super(s -> {});
    }

    public Day11(@NotNull Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Long solve1(@NotNull String input) {
        return CosmosLoader.parse(input, 2L).sumDistances();
    }

    @Override
    public @NotNull Long solve2(@NotNull String input) {
        return CosmosLoader.parse(input, 1000000L).sumDistances();
    }
}
