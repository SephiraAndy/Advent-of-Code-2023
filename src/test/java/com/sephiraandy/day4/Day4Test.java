package com.sephiraandy.day4;

import com.sephiraandy.util.Input;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {

    public static final String INPUT = """
        Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
        Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
        Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
        Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
        Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11""";

    @Test
    void part1() {
        assertThat(new Day4(s -> {}).solve1(INPUT)).isEqualTo(13);
    }

    @Test
    void part1Real() throws IOException {
        assertThat(new Day4(s -> {}).solve1(Input.loadTextFromFile("input/Day4"))).isEqualTo(21821);
    }

    @Test
    void part2() {
        assertThat(new Day4(s -> {}).solve2(INPUT)).isEqualTo(30);
    }

    @Test
    void part2Real() throws IOException {
        assertThat(new Day4(s -> {}).solve2(Input.loadTextFromFile("input/Day4"))).isEqualTo(5539496);
    }
}
