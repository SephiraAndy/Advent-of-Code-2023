package com.sephiraandy.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.function.Consumer;

public abstract class Puzzle<T> {

    private final Consumer<String> runTimeLogConsumer;

    public abstract @NotNull T solve1(final @NotNull String input);

    public abstract @NotNull T solve2(final @NotNull String input);

    protected Puzzle(final @NotNull Consumer<String> runTimeLogConsumer) {
        this.runTimeLogConsumer = runTimeLogConsumer;
    }

    public void solve(final @NotNull String inputPath) {
        var start = System.currentTimeMillis();
        final var input = loadInput(inputPath);
        var runTime = System.currentTimeMillis() - start;
        runTimeLogConsumer.accept("input file load time %sms.\n".formatted(runTime == 0 ? "< 1" : runTime));

        start = System.currentTimeMillis();
        solve1(input);
        runTime = System.currentTimeMillis() - start;
        runTimeLogConsumer.accept("part 1 execution time %sms.\n".formatted(runTime == 0 ? "< 1" : runTime));

        start = System.currentTimeMillis();
        solve2(input);
        runTime = System.currentTimeMillis() - start;
        runTimeLogConsumer.accept("part 2 execution time %sms.\n".formatted(runTime == 0 ? "< 1" : runTime));
    }

    private static @NotNull String loadInput(@NotNull String inputPath) {
        final String input;
        try {
            input = Input.loadTextFromFile(inputPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;
    }
}
