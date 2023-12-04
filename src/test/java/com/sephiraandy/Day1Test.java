package com.sephiraandy;

import com.sephiraandy.day1.Day1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Day1Test {
    @Test
    void part1() {
        var input = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet""";

        assertThat(Day1.solve1(input)).isEqualTo(142);
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

        assertThat(Day1.solve2(input)).isEqualTo(281);
    }
}
