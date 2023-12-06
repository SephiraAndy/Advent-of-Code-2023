package com.sephiraandy;

import com.sephiraandy.day6.Day6;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day6Test {

    private static final String INPUT = """
        Time:      7  15   30
        Distance:  9  40  200""";

    @Test
    void part1() {
        assertThat(new Day6(s -> {}).solve1(INPUT)).isEqualTo(288L);
    }

    @Test
    void part1Real() throws IOException {
        assertThat(new Day6(s -> {}).solve1(loadTextFromFile("input/Day6"))).isEqualTo(512295L);
    }

    @Test
    void part2() {
        assertThat(new Day6(s -> {}).solve2(INPUT)).isEqualTo(71503L);
    }

    @Test
    void part2Real() throws IOException {
        assertThat(new Day6(s -> {}).solve2(loadTextFromFile("input/Day6"))).isEqualTo(36530883L);
    }
}
