package com.sephiraandy.day4;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Day4 extends Puzzle<Integer> {
    public Day4(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public @NotNull Integer solve1(@NotNull String input) {
        return Input.lineStream(input)
            .map(Card::parse)
            .mapToInt(Card::score)
            .sum();
    }

    public @NotNull Integer solve2(@NotNull String input) {
        final var lines = Input.asLines(input);
        final var idsToQuantity = new HashMap<Integer, Integer>();
        var sum = 0;

        for (var line : lines) {
            final var card = Card.parse(line);

            final var count = idsToQuantity.containsKey(card.getId())
                ? 1 + idsToQuantity.remove(card.getId())
                : 1;

            final var numberOfMatches = card.matchCount();
            IntStream.rangeClosed(1 + card.getId(), numberOfMatches + card.getId())
                .forEach(cardToAdd -> idsToQuantity.put(cardToAdd, count + idsToQuantity.getOrDefault(cardToAdd, 0)));

            sum += count;
        }

        return sum;
    }
}
