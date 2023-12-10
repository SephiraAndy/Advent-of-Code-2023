package com.sephiraandy.day10;

import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

public class Day10 extends Puzzle<Integer> {
    public Day10() {
        super(s -> {});
    }

    public Day10(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public Integer solve1(String input) {
        return PipeMap.parse(input).findLoop().perimeter() / 2;
    }

    @Override
    public Integer solve2(String input) {
        return PipeMap.parse(input).findLoop().area();
    }
}
