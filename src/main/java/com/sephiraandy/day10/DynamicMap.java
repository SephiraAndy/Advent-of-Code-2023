package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DynamicMap {

    private static final int DYNAMIC_EMPTY = 0;
    private static final int DYNAMIC_PATH = 1;

    private final int @NotNull [] @NotNull [] dynamicMap;

    public DynamicMap(final int width,
                      final int height) {
        dynamicMap = new int[height][width];
    }

    public void setAsPath(final @NotNull GridVector start) {
        dynamicMap[start.y()][start.x()] = DYNAMIC_PATH;
    }

    public int width() {
        return dynamicMap[0].length;
    }

    public boolean isEmptyAt(final @NotNull GridVector position) {
        return dynamicMap[position.y()][position.x()] == DYNAMIC_EMPTY;
    }

    public void perRow(final @NotNull Consumer<Integer> rowIndexConsumer) {
        for (var i = 0; i < dynamicMap.length; ++i) {
            rowIndexConsumer.accept(i);
        }
    }

    public void perCell(Integer y, Consumer<GridVector> positionConsumer) {
        for (var x = 0; x < width(); ++x) {
            positionConsumer.accept(new GridVector(x, y));
        }
    }
}
