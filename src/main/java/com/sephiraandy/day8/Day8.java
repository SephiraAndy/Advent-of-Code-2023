package com.sephiraandy.day8;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day8 extends Puzzle<Long> {

    public static final String Z = "Z";

    public Day8() {
        this(s -> {
        });
    }

    public Day8(final Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Long solve1(final @NotNull String input) {
        final var startingPositions = new String[]{"AAA"};
        return DesertMap.parse(input).traverse(startingPositions, "ZZZ"::equals);
    }

    @Override
    public @NotNull Long solve2(final @NotNull String input) {
        final var desertMap = DesertMap.parse(input);
        final var startingPositions = desertMap.startingPositions();
        return desertMap.traverse(startingPositions, Day8::nodeEndsInZ);
    }

    private static boolean nodeEndsInZ(final String node) {
        return node.endsWith(Z);
    }
}
