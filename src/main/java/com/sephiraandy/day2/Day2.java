package com.sephiraandy.day2;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.Puzzle;

import java.util.function.Consumer;

public class Day2 extends Puzzle<Integer> {

    public Day2(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public Integer solve1(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .filter(Game::isValid)
            .mapToInt(Game::id)
            .sum();
    }

    public Integer solve2(String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .mapToInt(Game::powerOfMinimumSet)
            .sum();
    }
}
