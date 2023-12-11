package com.sephiraandy.day11;

import com.sephiraandy.util.Input;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CosmosLoader {
    public static @NotNull Cosmos parse(final @NotNull String input, long gapSize) {
        final var lines = Input.asLines(input);
        final var emptyRows = new ArrayList<Integer>();
        final var emptyColumns = new ArrayList<Integer>();

        for (var y = 0; y < lines.length; ++y) {
            var isEmpty = true;
            for (var x = 0; x < lines[y].length(); ++x) {
                if (lines[y].charAt(x) != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                emptyRows.add(y);
            }
        }

        for (var x = 0; x < lines[0].length(); ++x) {
            var isEmpty = true;
            for (String line : lines) {
                if (line.charAt(x) != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                emptyColumns.add(x);
            }
        }

        final var galaxies = new ArrayList<CosmosVector>();
        for (var y = 0; y < lines.length; ++y) {
            for (var x = 0; x < lines[y].length(); ++x) {
                if (lines[y].charAt(x) == '#') {
                    galaxies.add(new CosmosVector(x + (gapSize - 1L) * emptySpaceBefore(x, emptyColumns), y + (gapSize - 1L) * emptySpaceBefore(y, emptyRows)));
                }
            }
        }

        return new Cosmos(galaxies);
    }

    private static long emptySpaceBefore(final int compressedPosition, List<Integer> emptySpaces) {
        for (var i = 0; i < emptySpaces.size(); ++i) {
            if (compressedPosition < emptySpaces.get(i)) {
                return i;
            }
        }
        return emptySpaces.size();
    }
}
