package com.sephiraandy.util;

import java.io.IOException;
import java.util.function.Consumer;

public abstract class Puzzle<T> {

    private final Consumer<String> runTimeLogConsumer;

    public abstract T solve1(String input);
    public abstract T solve2(String input);

    protected Puzzle(Consumer<String> runTimeLogConsumer) {
        this.runTimeLogConsumer = runTimeLogConsumer;
    }

    public void solve(String inputPath) {
        var start = System.currentTimeMillis();
        final String input;
        try {
            input = Input.loadTextFromFile(inputPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
