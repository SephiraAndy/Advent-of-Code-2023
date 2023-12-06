package com.sephiraandy;

import com.sephiraandy.day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    public static final String INPUT = """
        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";

    @Test
    void part1() {
        assertThat(new Day2(s -> {}).solve1(INPUT)).isEqualTo(8);
    }

    @Test
    public void part1Real() throws IOException {
        assertThat(new Day2(s -> {}).solve1(loadTextFromFile("input/Day2"))).isEqualTo(2278);
    }

    @Test
    void part2() {
        assertThat(new Day2(s -> {}).solve2(INPUT)).isEqualTo(2286);
    }

    @Test
    public void part2Real() throws IOException {
        assertThat(new Day2(s -> {}).solve2(loadTextFromFile("input/Day2"))).isEqualTo(67953);
    }
}
