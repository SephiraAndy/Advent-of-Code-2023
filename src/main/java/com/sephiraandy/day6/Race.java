package com.sephiraandy.day6;

import com.sephiraandy.util.Input;

import java.util.ArrayList;
import java.util.List;

public record Race(long time, long distance) {
    public static List<Race> parseRaces(String input) {
        final var lines = Input.asLines(input);
        final var times = extractData(lines[0]);
        final var distances = extractData(lines[1]);
        final var races = new ArrayList<Race>();

        for (var race = 0; race < times.size(); ++ race) {
            races.add(new Race(times.get(race), distances.get(race)));
        }

        return races;
    }

    public static Race parseRace(String input) {
        final var lines = Input.asLines(input);
        final var time = concatExtractedData(lines[0]);
        final var distance = concatExtractedData(lines[1]);
        return new Race(time, distance);
    }

    private static Long concatExtractedData(String line) {
        StringBuilder data = new StringBuilder();
        final var rawTitleAndData = line.split(":");
        final var rawData = rawTitleAndData[1].split(" ");
        for (var rawValue : rawData) {
            if (rawValue.isBlank()) continue;
            data.append(rawValue.trim());
        }
        return Long.parseLong(data.toString());
    }

    private static List<Long> extractData(final String line) {
        final var data = new ArrayList<Long>();
        final var rawTitleAndData = line.split(":");
        final var rawData = rawTitleAndData[1].split(" ");
        for (var rawValue : rawData) {
            if (rawValue.isBlank()) continue;
            data.add(Long.parseLong(rawValue.trim()));
        }
        return data;
    }

    public Long numberOfWaysToBeat() {
        var first = 0L;

        for (long timeHeld = 1; timeHeld < time; ++timeHeld) {
            final var timeRemaining = time - timeHeld;
            var distanceTravelled = timeHeld * timeRemaining;
            if (distanceTravelled > distance) {
                first = timeHeld;
                break;
            }
        }

        var last = 0L;

        for (long timeHeld = (time - 1); timeHeld >= 1; --timeHeld) {
            final var timeRemaining = time - timeHeld;
            var distanceTravelled = timeHeld * timeRemaining;
            if (distanceTravelled > distance) {
                last = timeHeld;
                break;
            }
        }
        return last - first + 1;
    }
}
