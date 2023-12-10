package com.sephiraandy.day10;

public record Move(GridVector position, GridVector next) {
    public GridVector delta() {
        return new GridVector(next.x() - position.x(), next.y() - position.y());
    }
}
