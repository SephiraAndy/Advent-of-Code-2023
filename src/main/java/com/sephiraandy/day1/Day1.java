package com.sephiraandy.day1;

import com.sephiraandy.util.InputRetriever;

import java.io.IOException;

import static com.sephiraandy.util.Input.lineStream;

public class Day1 {

    public static int solve1(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .map(c -> c.readValue(c::digitForward, c::digitBackward))
            .reduce(0, Integer::sum);
    }

    public static int solve2(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .map(c -> c.readValue(c::numberForward, c::numberBackward))
            .reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws IOException {
        final var input = InputRetriever.get("input/Day1");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }

}
