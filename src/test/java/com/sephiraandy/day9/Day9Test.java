package com.sephiraandy.day9;

import com.sephiraandy.util.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {

    public static final String INPUT = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45""";
    private Day9 day9;

    @BeforeEach
    void setup() {
        day9 = new Day9();
    }

    @Test
    void part1Example() {
        final var solution = day9.solve1(INPUT);
        assertThat(solution).isEqualTo(114);
    }

    @Test
    void part1Real() throws IOException {
        final var input = Input.loadTextFromFile("input/Day9");
        final var solution = day9.solve1(input);
        assertThat(solution).isEqualTo(1868368343);
    }

    @Test
    void part2Example() {
        final var solution = day9.solve2(INPUT);
        assertThat(solution).isEqualTo(2);
    }

    @Test
    void part2Real() throws IOException {
        final var input = Input.loadTextFromFile("input/Day9");
        final var solution = day9.solve2(input);
        assertThat(solution).isEqualTo(1022);
    }
}