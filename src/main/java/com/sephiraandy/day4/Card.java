package com.sephiraandy.day4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Card {
    private final Set<Integer> winningNumbers;
    private final Set<Integer> numbersYouHave;
    private final int id;

    public Card(int id, Set<Integer> winningNumbers, Set<Integer> numbersYouHave) {
        this.id = id;
        this.winningNumbers = winningNumbers;
        this.numbersYouHave = numbersYouHave;
    }

    public int getId() {
        return id;
    }

    static Set<Integer> extractSetFromRaw(String raw) {
        final var rawArray = raw.split(" ");
        final var numbers = new HashSet<Integer>();
        for (var rawNumber : rawArray) {
            if (rawNumber.isBlank()) continue;
            numbers.add(Integer.parseInt(rawNumber));
        }
        return numbers;
    }

    static Card parse(String line) {
        final var rawCardAndNumbers = line.split(":");
        final var rawWinningNumbersAndNumbersYouHave = rawCardAndNumbers[1].trim().split("\\|");
        final var rawWinningNumbers = rawWinningNumbersAndNumbersYouHave[0].trim();
        final var rawNumbersYouHave = rawWinningNumbersAndNumbersYouHave[1].trim();

        final var winningNumbers = extractSetFromRaw(rawWinningNumbers);
        final var numbersYouHave = extractSetFromRaw(rawNumbersYouHave);
        final var id = Integer.parseInt(rawCardAndNumbers[0].replace("Card", "").trim());
        return new Card(id, Set.copyOf(winningNumbers), Set.copyOf(numbersYouHave));
    }

    public int score() {
        final var matchCount = getMatches().size();
        if (matchCount == 0) {
            return 0;
        }
        return IntStream.range(1, matchCount)
            .reduce(1, (a, b) -> a * 2);
    }

    private Collection<Integer> getMatches() {
        var matches = new HashSet<>(numbersYouHave);
        matches.retainAll(winningNumbers);
        return matches;
    }

    public int matchCount() {
        return getMatches().size();
    }
}
