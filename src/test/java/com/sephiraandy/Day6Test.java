package com.sephiraandy;

import com.sephiraandy.day6.Day6;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day6Test {

    private static final String INPUT = """
        Time:      7  15   30
        Distance:  9  40  200""";

    @Test
    void part1() {
        assertThat(new Day6(s -> {}).solve1(INPUT)).isEqualTo(288);
    }

    @Test
    void part2() {
        assertThat(new Day6(s -> {}).solve2(INPUT)).isEqualTo(71503);
    }
}
