package com.sephiraandy.day9;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
        return isDataRepeating(data[0])
            ? data[0]
            : data[data.length - 1] + differenceLayer(data).getNext();
    }

    public int getPrevious() {
        return isDataRepeating(data[0])
            ? data[0]
            : data[0] - differenceLayer(data).getPrevious();
    }

    @Contract(pure = true)
    private @NotNull Sequence differenceLayer(final int @NotNull [] data) {
        final var nextLayer = new int[data.length - 1];
        for (int i = 1; i < data.length; ++ i) {
            nextLayer[i - 1] = data[i] - data[i - 1];
        }
        return new Sequence(nextLayer);
    }

    @Contract(pure = true)
    private boolean isDataRepeating(final int contents) {
        var dataRepeats = true;
        for (var index = 1; index < data.length; ++index) {
            if (data[index] != contents) {
                dataRepeats = false;
                break;
            }
        }
        return dataRepeats;
    }
}
