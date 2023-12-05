package com.sephiraandy.util;

import java.io.IOException;

public abstract class Puzzle<T> {

    public abstract T solve1(String input);
    public abstract T solve2(String input);

    public void solve(String inputPath) throws IOException {
        var start = System.currentTimeMillis();
        final var input = Input.loadTextFromFile(inputPath);
        var end = System.currentTimeMillis();
        System.out.println("input file load time " + (end - start) + "ms.");

        start = System.currentTimeMillis();
        System.out.println(solve1(input).toString());
        end = System.currentTimeMillis();
        System.out.println("part 1 execution time " + (end - start) + "ms.");

        start = System.currentTimeMillis();
        System.out.println(solve2(input).toString());
        end = System.currentTimeMillis();
        System.out.println("part 2 execution time " + (end - start) + "ms.");
    }
}
