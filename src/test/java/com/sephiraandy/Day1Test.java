package com.sephiraandy;

import com.sephiraandy.day1.Day1;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {
    @Test
    void part1() {
        var input = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet""";

        assertThat(new Day1(s -> {}).solve1(input)).isEqualTo(142);
    }

    @Test
    void part1Real() throws IOException {
        assertThat(new Day1(s -> {}).solve1(loadTextFromFile("input/Day1"))).isEqualTo(55172);
    }

    @Test
    void part2() {
        var input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen""";

        assertThat(new Day1(s-> {}).solve2(input)).isEqualTo(281);
    }

    @Test
    void part2Real() throws IOException {
        assertThat(new Day1(s -> {}).solve2(loadTextFromFile("input/Day1"))).isEqualTo(54925);
    }
}
