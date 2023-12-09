package com.sephiraandy.day7;

import java.util.HashMap;
import java.util.Map;

import static com.sephiraandy.day7.Card.*;

public class Hand {

    private static final Map<Character, Integer> specialCharactersToValueWithJacks = Map.of(
        'A', 14,
        'K', 13,
        'Q', 12,
        'J', 11,
        'T', 10
    );

    private static final Map<Character, Integer> specialCharactersToValueWithJokers = Map.of(
        'A', 14,
        'K', 13,
        'Q', 12,
        'J', 1,
        'T', 10
    );
    public static final int FIVE_OF_A_KIND = 7;
    public static final int FOUR_OF_A_KIND = 6;
    public static final int FULL_HOUSE = 5;
    public static final int THREE_OF_A_KIND = 4;
    public static final int TWO_PAIRS = 3;
    public static final int ONE_PAIR = 2;
    public static final int HIGH_CARD = 1;

    private final Card[] cards;
    private final int rank;

    private Hand(Card... cards) {
        this.cards = cards;
        rank = evaluateRank();
    }

    private int evaluateRank() {
        final var cardCounts = collectCards();

        if (isFiveOfAKind(cardCounts)) return FIVE_OF_A_KIND;
        if (isFourOfAKind(cardCounts)) return FOUR_OF_A_KIND;
        if (isFullHouse(cardCounts)) return FULL_HOUSE;
        if (isThreeOfAKind(cardCounts)) return THREE_OF_A_KIND;
        if (isTwoPair(cardCounts)) return TWO_PAIRS;
        if (isOnePair(cardCounts)) return ONE_PAIR;
        return HIGH_CARD;
    }

    private boolean isFiveOfAKind(Map<Card, Integer> cardCounts) {
        final var jokers = cardCounts.getOrDefault(JOKER, 0);
        if (jokers == 5) return true;
        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;
            if (entry.getValue() + jokers == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean isFourOfAKind(Map<Card, Integer> cardCounts) {
        final var jokers = cardCounts.getOrDefault(JOKER, 0);
        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;
            if (entry.getValue() + jokers == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse(Map<Card, Integer> cardCounts) {
        var jokers = cardCounts.getOrDefault(JOKER, 0);
        Card threeFound = null;

        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;

            if (entry.getValue() + jokers == 3) {
                jokers -= (3 - entry.getValue());
                threeFound = entry.getKey();
                break;
            }
         }

        if (threeFound == null) {
            return false;
        }

        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER) ||
                entry.getKey().equals(threeFound)) {
                continue;
            }

            if (entry.getValue() + jokers == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(Map<Card, Integer> cardCounts) {
        var jokers = cardCounts.getOrDefault(JOKER, 0);

        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;
            if (entry.getValue() + jokers == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPair(Map<Card, Integer> cardCounts) {
        var jokers = cardCounts.getOrDefault(JOKER, 0);
        var pairCount = 0;
        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;

            if (entry.getValue() + jokers > 2) {
                return false;
            }
            if (entry.getValue() + jokers == 2) {
                jokers -= (2 - entry.getValue());
                ++pairCount;
            }
        }
        return pairCount == 2;
    }

    private boolean isOnePair(Map<Card, Integer> cardCounts) {
        var jokers = cardCounts.getOrDefault(JOKER, 0);
        var pairFound = false;
        for (var entry : cardCounts.entrySet()) {
            if (entry.getKey().equals(JOKER)) continue;

            if (entry.getValue() + jokers > 2) {
                return false;
            }

            if (entry.getValue() + jokers == 2) {
                if (pairFound) {
                    return false;
                }
                jokers -= (2 - entry.getValue());
                pairFound = true;
            }
        }
        return pairFound;
    }

    private Map<Card, Integer> collectCards() {
        var counts = new HashMap<Card, Integer>();
        for (var card : cards) {
            if (counts.containsKey(card)) {
                counts.put(card, counts.get(card) + 1);
            } else {
                counts.put(card, 1);
            }
        }
        return counts;
    }

    public static Hand parseWithJacks(String rawHand) {
        var cards = new Card[5];
        for (var i = 0; i < rawHand.length(); ++i) {
            cards[i] = new Card(charactersToValue(rawHand.charAt(i), specialCharactersToValueWithJacks));
        }
        return new Hand(cards);
    }

    public static Hand parseWithJokers(String rawHand) {
        var cards = new Card[5];
        for (var i = 0; i < rawHand.length(); ++i) {
            cards[i] = new Card(charactersToValue(rawHand.charAt(i), specialCharactersToValueWithJokers));
        }
        return new Hand(cards);
    }

    private static int charactersToValue(char c, Map<Character, Integer> specialCharactersToValue) {
        return c >= '2' && c <= '9'
            ? Character.getNumericValue(c)
            : specialCharactersToValue.get(c);
    }

    public int rank() {
        return rank;
    }

    public Card card(int i) {
        return cards[i];
    }
}
