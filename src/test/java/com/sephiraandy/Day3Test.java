package com.sephiraandy;

import com.sephiraandy.day3.Day3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;

public class Day3Test {

    public static final String INPUT = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..""";

    @Test
    void part1() {
        Assertions.assertThat(new Day3(s -> {}).solve1(INPUT)).isEqualTo(4361);
    }

    @Test
    void part1Real() throws IOException {
        Assertions.assertThat(new Day3(s -> {}).solve1(loadTextFromFile("input/Day3"))).isEqualTo(538046);
    }

    @Test
    void part2() {
        Assertions.assertThat(new Day3(s -> {}).solve2(INPUT)).isEqualTo(467835);
    }

    @Test
    void part2Real() throws IOException {
        Assertions.assertThat(new Day3(s -> {}).solve2(loadTextFromFile("input/Day3"))).isEqualTo(81709807);
    }
}
