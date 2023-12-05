package com.sephiraandy.day5;

import com.sephiraandy.util.Input;

import java.io.IOException;

import static com.sephiraandy.day5.SeedMap.*;

public class Day5 {
    public static long solve1(final String input) {
        final var lines = Input.asLines(input);
        return Seeds.parse(lines[0]).stream()
            .map(fetchData(lines, "seed-to-soil")::map)
            .map(fetchData(lines, "soil-to-fertilizer")::map)
            .map(fetchData(lines, "fertilizer-to-water")::map)
            .map(fetchData(lines, "water-to-light")::map)
            .map(fetchData(lines, "light-to-temperature")::map)
            .map(fetchData(lines, "temperature-to-humidity")::map)
            .map(fetchData(lines, "humidity-to-location")::map)
            .min()
            .orElse(0L);
    }

    public static long solve2(final String input) {
        final var lines = Input.asLines(input);
        return Seeds.parse(lines[0]).pairStream()
            .map(fetchData(lines, "seed-to-soil")::map)
            .map(fetchData(lines, "soil-to-fertilizer")::map)
            .map(fetchData(lines, "fertilizer-to-water")::map)
            .map(fetchData(lines, "water-to-light")::map)
            .map(fetchData(lines, "light-to-temperature")::map)
            .map(fetchData(lines, "temperature-to-humidity")::map)
            .map(fetchData(lines, "humidity-to-location")::map)
            .min()
            .orElse(0L);
    }

    public static void main(final String[] args) throws IOException {
        final var input = Input.loadTextFromFile("input/Day5");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }
}
