package com.sephiraandy.day2;

import com.sephiraandy.util.Input;
import com.sephiraandy.util.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Day2 extends Puzzle<Integer> {

    public Day2(Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    public @NotNull Integer solve1(@NotNull String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .filter(Game::isValid)
            .mapToInt(Game::id)
            .sum();
    }

    public @NotNull Integer solve2(@NotNull String input) {
        return Input.lineStream(input)
            .map(GameParser::parseGame)
            .mapToInt(Game::powerOfMinimumSet)
            .sum();
    }
}
