package com.sephiraandy.day5;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.Puzzle;

import java.io.IOException;
import java.util.function.Consumer;

import static com.sephiraandy.day5.SeedMap.fetchData;

public class Day5 extends Puzzle<Long> {
    public Day5(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public Long solve1(final String input) {
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

    public Long solve2(final String input) {
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
        new Day5(System.out::print).solve("input/Day5");
    }
}
