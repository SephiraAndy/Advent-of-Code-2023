package com.sephiraandy.day8;

import com.sephiraandy.util.Input;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class DesertMap {
    public static final String A = "A";
    private final String instructions;
    private final HashMap<String, Destinations> map;
    private final long instructionCount;

    private DesertMap(final String instructions,
                      final HashMap<String, Destinations> map) {
        instructionCount = instructions.length();
        this.instructions = instructions;
        this.map = map;
    }

    public static DesertMap parse(final String input) {
        final var lines = Input.asLines(input);
        final var instructions = lines[0];
        final var map = new HashMap<String, Destinations>();

        for (var i = 2; i < lines.length; ++i) {
            final var rawNodeAndDestinations = lines[i].split(" = ");
            map.put(rawNodeAndDestinations[0], Destinations.parse(rawNodeAndDestinations[1]));
        }

        return new DesertMap(instructions, map);
    }

    public long traverse(final String[] currentNodes,
                         final Predicate<String> complete) {

        final var intervals = new Long[currentNodes.length];
        for (var i = 0; i < currentNodes.length; ++i) {
            intervals[i] = 0L;
        }

        var steps = 0L;
        while (!Arrays.stream(currentNodes).allMatch(complete)) {
            final var instruction = instructions.charAt((int) (steps % instructionCount));
            for (var ghost = 0; ghost < currentNodes.length; ++ghost) {
                currentNodes[ghost] = map.get(currentNodes[ghost]).next(instruction);

                if (complete.test(currentNodes[ghost]) && intervals[ghost] == 0L) {
                    intervals[ghost] = steps + 1 - intervals[ghost];
                }
            }

            ++steps;
            if (Arrays.stream(intervals).allMatch(i -> i > 0)) {
                break;
            }
        }

        for (var i = 1; i < intervals.length; ++i) {
            var a = intervals[i - 1];
            var b = intervals[i];
            intervals[i] = a * b / highestCommonFactor(a, b);
        }

        return intervals[intervals.length - 1];
    }

    private long highestCommonFactor(long a, long b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public String[] startingPositions() {
        return map.keySet()
            .stream()
            .filter(DesertMap::nodeEndsWithA)
            .toArray(String[]::new);
    }

    private static boolean nodeEndsWithA(final String node) {
        return node.endsWith(A);
    }
}
