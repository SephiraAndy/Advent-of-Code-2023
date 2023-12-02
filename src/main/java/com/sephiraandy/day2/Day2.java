package com.sephiraandy.day2;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.InputRetriever;

import java.io.IOException;

public class Day2 {

    public static int solve1(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .filter(Game::isValid)
            .map(Game::id)
            .reduce(0, Integer::sum);
    }

    public static int solve2(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .map(Game::powerOfMinimumSet)
            .reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws IOException {
        final var input = InputRetriever.get("input/Day2");
        System.out.println(solve1(input));
        System.out.println(solve2(input));
    }
}
