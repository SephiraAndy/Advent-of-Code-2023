package com.sephiraandy.day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.sephiraandy.util.Input.loadTextFromFile;
import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {

    private static final String INPUT = """
            seeds: 79 14 55 13
                        
            seed-to-soil map:
            50 98 2
            52 50 48
                        
            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15
                        
            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4
                        
            water-to-light map:
            88 18 7
            18 25 70
                        
            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13
                        
            temperature-to-humidity map:
            0 69 1
            1 0 69
                        
            humidity-to-location map:
            60 56 37
            56 93 4""";

    @Test
    void part1() {
        assertThat(new Day5(s -> {}).solve1(INPUT)).isEqualTo(35L);
    }

    @Test
    void part1Real() throws IOException {
        assertThat(new Day5(s -> {}).solve1(loadTextFromFile("input/Day5"))).isEqualTo(382895070L);
    }

    @Test
    void part2() {
        assertThat(new Day5(s -> {}).solve2(INPUT)).isEqualTo(46L);
    }

    @Test
    void part2Real() throws IOException {
        assertThat(new Day5(s -> {}).solve2(loadTextFromFile("input/Day5"))).isEqualTo(17729182L);
    }
}
