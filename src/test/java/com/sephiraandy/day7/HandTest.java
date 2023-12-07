package com.sephiraandy.day7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.sephiraandy.day7.Hand.*;

class HandTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "22222",
        "2222J",
        "J222J",
        "J2J2J",
        "JJJ2J",
        "JJJJJ"
    })
    void fiveOfAKind(String hand) {
        Assertions.assertThat(parseWithJokers(hand).rank())
            .isEqualTo(FIVE_OF_A_KIND);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "22223",
        "2223J",
        "J223J",
        "J2J3J"
    })
    void fourOfAKind(String hand) {
        Assertions.assertThat(parseWithJokers(hand).rank())
            .isEqualTo(FOUR_OF_A_KIND);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "32223",
        "3223J"
    })
    void fullHouse(String hand) {
        Assertions.assertThat(parseWithJokers(hand).rank())
            .isEqualTo(FULL_HOUSE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "32224",
        "3J242",
        "3JJ42"
    })
    void threeOfAKind(String hand) {
        Assertions.assertThat(parseWithJokers(hand).rank())
            .isEqualTo(THREE_OF_A_KIND);
    }
}