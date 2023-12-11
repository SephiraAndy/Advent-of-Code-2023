package com.sephiraandy.day11;

import com.sephiraandy.util.Input;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CosmosLoader {
    public static @NotNull Cosmos parse(final @NotNull String input,
                                        final long gapSize) {
        final var lines = Input.asLines(input);
        return new Cosmos(parseGalaxies(gapSize, lines, findEmptyColumns(lines), findEmptyRows(lines)));
    }

    private static @NotNull ArrayList<Integer> findEmptyRows(String[] lines) {
        final var emptyRows = new ArrayList<Integer>();
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
        return emptyRows;
    }

    private static @NotNull ArrayList<Integer> findEmptyColumns(String[] lines) {
        final var emptyColumns = new ArrayList<Integer>();
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
        return emptyColumns;
    }

    private static @NotNull ArrayList<CosmosVector> parseGalaxies(final long gapSize,
                                                                  final String[] lines,
                                                                  final @NotNull ArrayList<Integer> emptyColumns,
                                                                  final @NotNull ArrayList<Integer> emptyRows) {
        final var padding = gapSize - 1L;
        final var galaxies = new ArrayList<CosmosVector>();
        for (var y = 0; y < lines.length; ++y) {
            for (var x = 0; x < lines[y].length(); ++x) {
                if (lines[y].charAt(x) == '#') {
                    final var galaxyX = x + padding * emptySpaceBefore(x, emptyColumns);
                    final var galaxyY = y + padding * emptySpaceBefore(y, emptyRows);
                    galaxies.add(new CosmosVector(galaxyX, galaxyY));
                }
            }
        }
        return galaxies;
    }

    private static long emptySpaceBefore(final int compressedPosition,
                                         final @NotNull List<Integer> emptySpaces) {
        for (var i = 0; i < emptySpaces.size(); ++i) {
            if (compressedPosition < emptySpaces.get(i)) {
                return i;
            }
        }
        return emptySpaces.size();
    }
}
