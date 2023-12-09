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
        var dataRepeats = true;
        for (var index = 1; index < data.length; ++index) {
            if (data[index] != contents) {
                dataRepeats = false;
                break;
            }
        }
        if (dataRepeats) return contents;

        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }

        return getNext(nextLayer) + data[data.length - 1];
    }

    @Override
    public Integer solve2(final String input) {
        return lineStream(input)
            .map(Day9::parseLine)
            .mapToInt(Day9::getPrevious)
            .sum();
    }

    private static int getPrevious(int[] data) {
        final var contents = data[0];
        var dataRepeats = true;
        for (var index = 1; index < data.length; ++index) {
            if (data[index] != contents) {
                dataRepeats = false;
                break;
            }
        }
        if (dataRepeats) return contents;

        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }

        return data[0] - getPrevious(nextLayer);
    }
}
