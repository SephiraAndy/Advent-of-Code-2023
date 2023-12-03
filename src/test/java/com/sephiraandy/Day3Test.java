package com.sephiraandy;

import com.sephiraandy.day3.Day3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {

    @Test
    void par1() {
        final var input = """
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

        final var solution = Day3.solve1(input);

        Assertions.assertThat(solution).isEqualTo(4361);
    }

    @Test
    void par2() {
        final var input = """
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

        final var solution = Day3.solve2(input);

        Assertions.assertThat(solution).isEqualTo(467835);
    }
}
