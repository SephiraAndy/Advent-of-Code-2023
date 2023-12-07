package com.sephiraandy.day7;

public record Card(int value) {
    public static final Card JOKER = new Card(1);
}
