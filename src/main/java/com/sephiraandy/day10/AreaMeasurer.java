package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.PipeMapTile.createMapTile;

class AreaMeasurer {

    private static final int DYNAMIC_EMPTY = 0;
    private static final int DYNAMIC_PATH = 1;

    private final PipeMap pipeMap;
    private GridVector initialDirection;
    private final int[][] dynamicMap;
    private int area;

    AreaMeasurer(final @NotNull PipeMap pipeMap) {
        this.pipeMap = pipeMap;
        dynamicMap = new int[pipeMap.height()][pipeMap.width()];
    }

    public void init(final @NotNull GridVector initialDirection) {
        this.initialDirection = initialDirection;
        final var start = pipeMap.start();
        dynamicMap[start.y()][start.x()] = DYNAMIC_PATH;
    }

    public int onComplete(final @NotNull MoveResult result) {
        final var startTile = createMapTile(result.direction(), initialDirection);
        for (var y = 0; y < dynamicMap.length; ++y) {
            PipeMapTile cornerStart = null;
            var isOutside = true;
            final var rowLength = dynamicMap[y].length;
            for (var x = 0; x < rowLength; ++x) {
                if (dynamicMap[y][x] == DYNAMIC_EMPTY) {
                    if (!isOutside) {
                        ++area;
                    }
                    continue;
                }

                final var currentPosition = new GridVector(x, y);
                final var pipeMapTile = currentPosition.equals(pipeMap.start())
                    ? startTile
                    : pipeMap.getTileAt(currentPosition);

                if (pipeMapTile.isHorizontal()) {
                    continue;
                }

                if (pipeMapTile.isVertical()) {
                    isOutside = !isOutside;
                    continue;
                }

                if (cornerStart == null) {
                    cornerStart = pipeMapTile;
                    continue;
                }

                isOutside = (cornerStart.polarity() == pipeMapTile.polarity()) != isOutside;
                cornerStart = null;
            }
        }
        return area;
    }

    public void postUpdate(final @NotNull GridVector position) {
        dynamicMap[position.y()][position.x()] = DYNAMIC_PATH;
    }

}
