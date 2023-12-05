package com.sephiraandy.day1;

import java.util.Map;
import java.util.OptionalInt;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

record CalibrationLine(String line) {
    private static final Map<Integer, String> numbers = Map.of(
        1, "one",
        2, "two",
        3, "three",
        4, "four",
        5, "five",
        6, "six",
        7, "seven",
        8, "eight",
        9, "nine");

    OptionalInt digitForward(final int position) {
        return digit(forward(position));
    }

    OptionalInt digitBackward(final int position) {
        return digit(backward(position));
    }

    int readValue(final IntFunction<OptionalInt> forwardFinder,
                  final IntFunction<OptionalInt> backwardFinder) {
        final var tens = findFirst(forwardFinder);
        final var units = findFirst(backwardFinder);
        return tens * 10 + units;
    }

    OptionalInt numberForward(final int position) {
        return number(forward(position), this::wordMatchesFromStart);
    }

    OptionalInt numberBackward(final int position) {
        return number(backward(position), this::wordMatchesFromEnd);
    }

    private boolean wordMatchesFromStart(final int wordStartPosition,
                                         final String word) {
        final var wordEndPosition = wordStartPosition + word.length();
        return wordEndPosition < line.length() && line.substring(wordStartPosition, wordEndPosition).equals(word);
    }

    private OptionalInt getNumber(final int position,
                                  final BiPredicate<Integer, String> wordMatches) {
        return numbers.entrySet().stream()
            .filter(entry -> wordMatches.test(position, entry.getValue()))
            .findFirst()
            .map(e -> OptionalInt.of(e.getKey()))
            .orElse(OptionalInt.empty());
    }

    private OptionalInt number(final int position,
                               final BiPredicate<Integer, String> wordMatches) {
        final var c = line.charAt(position);
        return Character.isDigit(c)
            ? OptionalInt.of(Character.getNumericValue(c))
            : getNumber(position, wordMatches);
    }

    private boolean wordMatchesFromEnd(final int wordEndPosition,
                                       final String word) {
        var wordStartPosition = wordEndPosition + 1 - word.length();
        return wordStartPosition >= 0 && (line.substring(wordStartPosition, wordEndPosition + 1).equals(word));
    }

    IntStream positionStream() {
        return IntStream.rangeClosed(0, lastCharacter());
    }

    int lastCharacter() {
        return line.length() - 1;
    }

    int forward(int position) {
        return position;
    }

    int backward(int position) {
        return lastCharacter() - position;
    }

    OptionalInt digit(final int position) {
        final var c = line.charAt(position);
        return Character.isDigit(c)
            ? OptionalInt.of(Character.getNumericValue(c))
            : OptionalInt.empty();
    }

    int findFirst(final IntFunction<OptionalInt> finder) {
        return positionStream()
            .mapToObj(finder)
            .filter(OptionalInt::isPresent)
            .map(OptionalInt::getAsInt)
            .findFirst()
            .orElse(0);
    }
}
