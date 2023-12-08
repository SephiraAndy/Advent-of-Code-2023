package com.sephiraandy.day8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day8Test {

    public static final String INPUT_DAY_8 = "input/Day8";

    private Day8 puzzle;

    @BeforeEach
    void setup() {
        puzzle = new Day8();
    }

    @Test
    void part1Example1() {
        final var input = """
            RL
                        
            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)""";

        final var solution = puzzle.solve1(input);
        assertThat(solution).isEqualTo(2);
    }

    @Test
    void part1Example2() {
        final var input = """
            LLR
                        
            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)""";

        final var solution = puzzle.solve1(input);
        assertThat(solution).isEqualTo(6);
    }

    @Test
    void part1Real() throws IOException {
        final var input = loadTextFromFile(INPUT_DAY_8);
        final var solution = puzzle.solve1(input);
        assertThat(solution).isEqualTo(20093);
    }

    @Test
    void part2Example() {
        final var input = """
            LR
                        
            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)""";

        final var solution = puzzle.solve2(input);
        assertThat(solution).isEqualTo(6);
    }

    @Test
    void part2Real() throws IOException {
        final var input = loadTextFromFile(INPUT_DAY_8);
        final var solution = puzzle.solve2(input);
        assertThat(solution).isEqualTo(22103062509257L);
    }
}
