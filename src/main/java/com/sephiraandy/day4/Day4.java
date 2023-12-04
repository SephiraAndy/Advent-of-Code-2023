package com.sephiraandy.day4;

import com.sephiraandy.util.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Day4 {
    public static int solve1(String input) {
        return Input.lineStream(input)
            .map(Card::parse)
            .mapToInt(Card::score)
            .sum();
    }

    public static int solve2(String input) {
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

    public static void main(String[] args) throws IOException {
        final var input = Input.loadTextFromFile("input/Day4");
        out.println(solve1(input));
        out.println(solve2(input));
    }
}
