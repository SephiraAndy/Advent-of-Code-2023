package com.sephiraandy.day1;

import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

import static com.sephiraandy.util.Input.lineStream;

public class Day1 extends Puzzle<Integer> {

    public Day1(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public Integer solve1(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::digitForward, c::digitBackward))
            .sum();
    }

    public Integer solve2(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::numberForward, c::numberBackward))
            .sum();
    }
}
