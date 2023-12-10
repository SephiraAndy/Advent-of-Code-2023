package com.sephiraandy.day10;

public class RowReader {
    private PipeMapTile cornerStart = null;
    private boolean outside = true;

    public boolean isOutside() {
        return outside;
    }

    public void invertOutside() {
        outside = !outside;
    }

    public void acceptCornerTile(PipeMapTile pipeMapTile) {
        if (cornerStart == null) {
            cornerStart = pipeMapTile;
            return;
        }

        outside = (cornerStart.polarity() == pipeMapTile.polarity()) != outside;
        cornerStart = null;
    }
}
