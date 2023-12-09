package com.sephiraandy.day9;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class Sequence {
    private final int[] data;

    private Sequence(int[] data) {
        this.data = data;
    }

    public static @NotNull Sequence parseLine(final @NotNull String line) {
        final var raw = line.split(" ");
        final var data = new int[raw.length];
        for (var index = 0; index < raw.length; ++index) {
            data[index] = Integer.parseInt(raw[index]);
        }
        return new Sequence(data);
    }

    public int getNext() {
        return continueSequence(this::next);
    }

    private int next() {
        return data[data.length - 1] + differenceLayer().getNext();
    }

    public int getPrevious() {
        return continueSequence(this::previous);
    }

    private int previous() {
        return data[0] - differenceLayer().getPrevious();
    }

    private int continueSequence(Supplier<Integer> previous) {
        return isDataRepeating()
            ? data[0]
            : previous.get();
    }

    private @NotNull Sequence differenceLayer() {
        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }
        return new Sequence(nextLayer);
    }

    private boolean isDataRepeating() {
        final int contents = data[0];
        for (var index = 1; index < data.length; ++index) {
            if (data[index] != contents) {
                return false;
            }
        }
        return true;
    }
}
