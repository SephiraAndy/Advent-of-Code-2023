package com.sephiraandy.day1;

import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.sephiraandy.util.Input.lineStream;

public class Day1 extends Puzzle<Integer> {

    public Day1(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public @NotNull Integer solve1(final @NotNull String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::digitForward, c::digitBackward))
            .sum();
    }

    public @NotNull Integer solve2(final @NotNull String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::numberForward, c::numberBackward))
            .sum();
    }
}
