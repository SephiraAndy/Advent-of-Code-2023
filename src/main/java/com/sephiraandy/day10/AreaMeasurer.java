package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.PipeMapTile.createMapTile;

class AreaMeasurer implements MapMeasurer {

    private final @NotNull PipeTileContainer pipeTileContainer;
    private final DynamicMap dynamicMap;
    private GridVector initialDirection;
    private int area;

    AreaMeasurer(final @NotNull PipeTileContainer pipeTileContainer) {
        this.pipeTileContainer = pipeTileContainer;
        dynamicMap = new DynamicMap(pipeTileContainer.width(), pipeTileContainer.height());
    }

    @Override
    public void init(final @NotNull GridVector initialDirection) {
        this.initialDirection = initialDirection;
        dynamicMap.setAsPath(pipeTileContainer.start());
    }

    @Override
    public void preUpdate() {

    }

    @Override
    public int onComplete(final @NotNull MoveResult result) {
        final var startTile = createMapTile(result.direction(), initialDirection);

        dynamicMap.perRow(y -> {
            final var rowReader = new RowReader();
            dynamicMap.perCell(y, currentPosition -> {
                if (dynamicMap.isEmptyAt(currentPosition)) {
                    if (!rowReader.isOutside()) {
                        ++area;
                    }
                    return;
                }

                final var pipeMapTile = currentPosition.equals(pipeTileContainer.start())
                    ? startTile
                    : pipeTileContainer.getTileAt(currentPosition);

                if (pipeMapTile.isHorizontal()) {
                    return;
                }

                if (pipeMapTile.isVertical()) {
                    rowReader.invertOutside();
                    return;
                }

                rowReader.acceptCornerTile(pipeMapTile);
            });

        });

        return area;
    }

    @Override
    public void postUpdate(final @NotNull GridVector position) {
        dynamicMap.setAsPath(position);
    }

}
