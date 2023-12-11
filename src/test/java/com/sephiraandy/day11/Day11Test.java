package com.sephiraandy.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

class Day11Test {

    public static final String INPUT = """
        ...#......
        .......#..
        #.........
        ..........
        ......#...
        .#........
        .........#
        ..........
        .......#..
        #...#.....""";

    @Test
    void part1Example() {
        final var day11 = new Day11();
        final var solution = day11.solve1(INPUT);
        assertThat(solution).isEqualTo(374L);
    }

    @Test
    void part1Real() throws IOException {
        final var input = loadTextFromFile("input/Day11");
        final var day11 = new Day11();
        final var solution = day11.solve1(input);
        assertThat(solution).isEqualTo(9550717L);
    }

    @Test
    void part2Example1() {
        var solution = CosmosLoader.parse(INPUT, 10L).sumDistances();
        assertThat(solution).isEqualTo(1030L);
    }

    @Test
    void part2Example2() {
        var solution = CosmosLoader.parse(INPUT, 100L).sumDistances();
        assertThat(solution).isEqualTo(8410L);
    }

    @Test
    void part2Real() throws IOException {
        final var input = loadTextFromFile("input/Day11");
        final var day11 = new Day11();
        final var solution = day11.solve2(input);
        assertThat(solution).isEqualTo(648458253817L);
    }
}