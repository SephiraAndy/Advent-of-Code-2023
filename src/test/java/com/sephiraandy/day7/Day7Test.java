package com.sephiraandy.day7;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day7Test {
    private static final String INPUT = """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483""";

    @Test
    void part1() {
        assertThat(new Day7(s -> {}).solve1(INPUT)).isEqualTo(6440L);
    }

    @Test
    void partReal() throws IOException {
        assertThat(new Day7(s -> {}).solve1(loadTextFromFile("input/Day7"))).isEqualTo(250058342L);
    }

    @Test
    void part2() {
        assertThat(new Day7(s -> {}).solve2(INPUT)).isEqualTo(5905L);
    }

    @Test
    void part2Real() throws IOException {
        assertThat(new Day7(s -> {}).solve2(loadTextFromFile("input/Day7"))).isEqualTo(250506580L);
    }
}
