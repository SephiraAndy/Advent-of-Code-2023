package com.sephiraandy.day9;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.sephiraandy.util.Input.lineStream;

public class Day9 extends Puzzle<Integer> {

    public static final String INPUT_PATH = "input/Day9";

    public Day9() {
        this(s -> {
        });
    }

    public Day9(final Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public @NotNull Integer solve1(final @NotNull String input) {
        return lineStream(input)
            .map(Sequence::parseLine)
            .mapToInt(Sequence::getNext)
            .sum();
    }

    @Override
    public @NotNull Integer solve2(final @NotNull String input) {
        return lineStream(input)
            .map(Sequence::parseLine)
            .mapToInt(Sequence::getPrevious)
            .sum();
    }
}
