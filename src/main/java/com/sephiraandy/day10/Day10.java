package com.sephiraandy.day10;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day10 extends Puzzle<Integer> {
    public Day10() {
        super(s -> {});
    }

    public Day10(final @NotNull Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Integer solve1(final @NotNull String input) {
        return PipeMap.parse(input)
            .flatMap(map -> map.evaluate(new PerimeterMeasurer()))
            .map(perimeter -> perimeter / 2)
            .orElse(0);
    }

    @Override
    public @NotNull Integer solve2(final @NotNull String input) {
        return PipeMap.parse(input)
            .flatMap(pipeMap -> pipeMap.evaluate(new AreaMeasurer(pipeMap)))
            .orElse(0);
    }
}
