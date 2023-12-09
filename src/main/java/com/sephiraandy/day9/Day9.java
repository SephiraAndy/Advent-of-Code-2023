package com.sephiraandy.day9;

import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

import static com.sephiraandy.util.Input.lineStream;

public class Day9 extends Puzzle<Integer> {
    public Day9() {
        this(s -> {
        });
    }

    public Day9(final Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public Integer solve1(final String input) {
        return lineStream(input)
            .map(Day9::parseLine)
            .mapToInt(Day9::getNext)
            .sum();
    }

    private static int[] parseLine(String line) {
        final var raw = line.split(" ");
        final var data = new int[raw.length];
        for (var index = 0; index < raw.length; ++index) {
            data[index] = Integer.parseInt(raw[index]);
        }
        return data;
    }

    private static int getNext(final int[] data) {
        final var contents = data[0];
        if (isDataRepeating(data, contents)) return contents;

        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }

        return data[data.length - 1] + getNext(nextLayer);
    }

    private static int getPrevious(int[] data) {
        final var contents = data[0];
        if (isDataRepeating(data, contents)) return contents;

        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }

        return data[0] - getPrevious(nextLayer);
    }

    private static boolean isDataRepeating(int[] data, int contents) {
        var dataRepeats = true;
        for (var index = 1; index < data.length; ++index) {
            if (data[index] != contents) {
                dataRepeats = false;
                break;
            }
        }
        return dataRepeats;
    }

    @Override
    public Integer solve2(final String input) {
        return lineStream(input)
            .map(Day9::parseLine)
            .mapToInt(Day9::getPrevious)
            .sum();
    }
}
