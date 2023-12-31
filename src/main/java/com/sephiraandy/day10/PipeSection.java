package com.sephiraandy.day10;

import org.jetbrains.annotations.NotNull;

import static com.sephiraandy.day10.GridVector.*;

public class PipeSection implements PipeMapTile {
    private final @NotNull GridVector entry1;
    private final @NotNull GridVector exit1;
    private final @NotNull GridVector entry2;
    private final @NotNull GridVector exit2;

    public PipeSection(final @NotNull GridVector entry1,
                       final @NotNull GridVector exit1,
                       final @NotNull GridVector entry2,
                       final @NotNull GridVector exit2) {
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
        return entry1 != UP || exit1 != LEFT;
    }
}
