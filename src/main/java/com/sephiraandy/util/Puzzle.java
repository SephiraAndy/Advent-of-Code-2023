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
        var end = System.currentTimeMillis();
        runTimeLogConsumer.accept("input file load time " + (end - start) + "ms.\n");

        start = System.currentTimeMillis();
        solve1(input);
        end = System.currentTimeMillis();
        runTimeLogConsumer.accept("part 1 execution time " + (end - start) + "ms.\n");

        start = System.currentTimeMillis();
        solve2(input);
        end = System.currentTimeMillis();
        runTimeLogConsumer.accept("part 2 execution time " + (end - start) + "ms.\n");
    }
}
