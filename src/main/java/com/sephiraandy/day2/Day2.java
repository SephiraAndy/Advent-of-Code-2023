package com.sephiraandy.day2;

import com.sephiraandy.util.Input;

import java.io.IOException;

public class Day2 {

    public static int solve1(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .filter(Game::isValid)
            .mapToInt(Game::id)
            .sum();
    }

    public static int solve2(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .mapToInt(Game::powerOfMinimumSet)
            .sum();
    }

    public static void main(String[] args) throws IOException {
        final var input = Input.loadTextFromFile("input/Day2");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }
}
