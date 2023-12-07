package com.sephiraandy.day7;

public record HandBid(Hand hand, long bid) implements Comparable<HandBid> {
    @Override
    public int compareTo(HandBid other) {
        var rankComparison = Integer.compare(hand.rank(), other.hand.rank());
        if (rankComparison != 0) return rankComparison;

        for (int i = 0; i < 5; ++i) {
            var comp = Integer.compare(hand.card(i).value(), other.hand.card(i).value());
            if (comp != 0) return comp;
        }

        return 0;
    }

    public static HandBid parseWithJacks(String line) {
        final var rawHandAndBid = line.split(" ");
        return new HandBid(Hand.parseWithJacks(rawHandAndBid[0]), Long.parseLong(rawHandAndBid[1]));
    }

    public static HandBid parseWithJokers(String line) {
        final var rawHandAndBid = line.split(" ");
        return new HandBid(Hand.parseWithJokers(rawHandAndBid[0]), Long.parseLong(rawHandAndBid[1]));
    }
}
