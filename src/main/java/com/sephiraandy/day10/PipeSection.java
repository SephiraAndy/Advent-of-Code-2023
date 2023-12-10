package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.GridVector.*;

public class PipeSection implements PipeMapTile {
    private final GridVector entry1;
    private final GridVector exit1;
    private final GridVector entry2;
    private final GridVector exit2;

    public PipeSection(GridVector entry1, GridVector exit1, GridVector entry2, GridVector exit2) {
        this.entry1 = entry1;
        this.exit1 = exit1;
        this.entry2 = entry2;
        this.exit2 = exit2;
    }

    @Override
    public @NotNull MoveResult move(final @NotNull GridVector delta,
                                    final @NotNull GridVector next) {
        if (delta.equals(entry1)) {
            final var nextMove = new Move(next, next.translate(exit1));
            return MoveResult.continues(nextMove);
        }
        if (delta.equals(entry2)) {
            final var nextMove = new Move(next, next.translate(exit2));
            return MoveResult.continues(nextMove);
        }
        return MoveResult.invalidMove();
    }

    @Override
    public boolean isHorizontal() {
        return (entry1 == RIGHT && exit1 == RIGHT) || (entry2 == RIGHT && exit2 == RIGHT);
    }

    @Override
    public boolean isVertical() {
        return (entry1 == DOWN && exit1 == DOWN) || (entry2 == DOWN && exit2 == DOWN);
    }

    @Override
    public boolean polarity() {
        if (entry1 == DOWN && exit1 == RIGHT) return false;
        if (entry1 == RIGHT && exit1 == DOWN) return false;
        if (entry1 == LEFT && exit1 == UP) return false;
        if (entry1 == UP && exit1 == LEFT) return false;
        return true;
    }
}
