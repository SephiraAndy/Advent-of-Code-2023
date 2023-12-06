package com.sephiraandy.day5;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.Puzzle;

import java.util.List;
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

        return Seeds.parse(lines[0]).rangeStream()
            .map(fetchData(lines, "seed-to-soil")::map).flatMap(List::stream)
            .map(fetchData(lines, "soil-to-fertilizer")::map).flatMap(List::stream)
            .map(fetchData(lines, "fertilizer-to-water")::map).flatMap(List::stream)
            .map(fetchData(lines, "water-to-light")::map).flatMap(List::stream)
            .map(fetchData(lines, "light-to-temperature")::map).flatMap(List::stream)
            .map(fetchData(lines, "temperature-to-humidity")::map).flatMap(List::stream)
            .map(fetchData(lines, "humidity-to-location")::map).flatMap(List::stream)
            .mapToLong(SeedRange::start).min().orElse(0L);
    }
}
