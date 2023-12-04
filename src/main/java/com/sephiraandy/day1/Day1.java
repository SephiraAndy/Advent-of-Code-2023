package com.sephiraandy.day1;

import com.sephiraandy.util.Input;

import java.io.IOException;

import static com.sephiraandy.util.Input.lineStream;

public class Day1 {

    public static int solve1(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::digitForward, c::digitBackward))
            .sum();
    }

    public static int solve2(final String input) {
        return lineStream(input)
            .map(CalibrationLine::new)
            .mapToInt(c -> c.readValue(c::numberForward, c::numberBackward))
            .sum();
    }

    public static void main(String[] args) throws IOException {
        final var input = Input.loadTextFromFile("input/Day1");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }

}
