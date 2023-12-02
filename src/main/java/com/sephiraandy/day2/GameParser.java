package com.sephiraandy.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameParser {
    static Game parseGame(final String line) {
        final var rawGameAndData = line.split(":");
        final var rawGame = rawGameAndData[0];
        final var rawGameId = rawGame.split(" ")[1];
        final var gameId = Integer.parseInt(rawGameId);
        final var rawData = rawGameAndData[1];
        final var rawReveals = rawData.split(";");

        final var reveals = new ArrayList<Map<String, Integer>>();

        for (var rawReveal : rawReveals) {
            final var rawDraws = rawReveal.split(",");
            final var draw = new HashMap<String, Integer>();
            for (var rawDraw : rawDraws) {
                final var rawColourAndQuantity = rawDraw.trim().split(" ");
                draw.put(rawColourAndQuantity[1], Integer.parseInt(rawColourAndQuantity[0]));
            }
            reveals.add(draw);
        }

        return new Game(gameId, reveals);
    }
}
