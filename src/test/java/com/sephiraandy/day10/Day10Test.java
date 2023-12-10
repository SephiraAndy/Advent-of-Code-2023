package com.sephiraandy.day10;

import com.sephiraandy.util.Input;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day10Test {

    @Test
    void part1Example1() {
        final var input = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....""";

        final var day10 = new Day10();
        final var solution = day10.solve1(input);
        assertThat(solution).isEqualTo(4);
    }

    @Test
    void part1Example2() {
        final var input = """
            -L|F7
            7S-7|
            L|7||
            -L-J|
            L|-JF""";

        final var day10 = new Day10();
        final var solution = day10.solve1(input);
        assertThat(solution).isEqualTo(4);
    }

    @Test
    void part1Example3() {
        final var input = """
            7-F7-
            .FJ|7
            SJLL7
            |F--J
            LJ.LJ""";

        final var day10 = new Day10();
        final var solution = day10.solve1(input);
        assertThat(solution).isEqualTo(8);
    }

    @Test
    void part1Real() throws IOException {
        final var input = Input.loadTextFromFile("input/Day10");
        final var day10 = new Day10();
        final var solution = day10.solve1(input);
        assertThat(solution).isEqualTo(6923);
    }

    @Test
    void part2Example1() {
        final var input = """
            ...........
            .S-------7.
            .|F-----7|.
            .||.....||.
            .||.....||.
            .|L-7.F-J|.
            .|..|.|..|.
            .L--J.L--J.
            ...........""";

        final var day10 = new Day10();
        final var solution = day10.solve2(input);
        assertThat(solution).isEqualTo(4);
    }

    @Test
    void part2Example2() {
        final var input = """
            .F----7F7F7F7F-7....
            .|F--7||||||||FJ....
            .||.FJ||||||||L7....
            FJL7L7LJLJ||LJ.L-7..
            L--J.L7...LJS7F-7L7.
            ....F-J..F7FJ|L7L7L7
            ....L7.F7||L7|.L7L7|
            .....|FJLJ|FJ|F7|.LJ
            ....FJL-7.||.||||...
            ....L---J.LJ.LJLJ...""";

        final var day10 = new Day10();
        final var solution = day10.solve2(input);
        assertThat(solution).isEqualTo(8);
    }

    @Test
    void part2Example3() {
        final var input = """
            FF7FSF7F7F7F7F7F---7
            L|LJ||||||||||||F--J
            FL-7LJLJ||||||LJL-77
            F--JF--7||LJLJ7F7FJ-
            L---JF-JLJ.||-FJLJJ7
            |F|F-JF---7F7-L7L|7|
            |FFJF7L7F-JF7|JL---7
            7-L-JL7||F7|L7F-7F7|
            L.L7LFJ|||||FJL7||LJ
            L7JLJL-JLJLJL--JLJ.L""";

        final var day10 = new Day10();
        final var solution = day10.solve2(input);
        assertThat(solution).isEqualTo(10);
    }

    @Test
    void part2Real() throws IOException {
        final var input = Input.loadTextFromFile("input/Day10");

        final var day10 = new Day10();
        final var solution = day10.solve2(input);
        assertThat(solution).isEqualTo(529);
    }
}