package com.sephiraandy.day2;

import java.util.List;
import java.util.Map;

record Game(int id, List<Map<String, Integer>> reveals) {
    boolean isValid() {
        for (var reveal : reveals()) {
            for (var entry : reveal.entrySet()) {
                final var colour = entry.getKey();
                switch (colour) {
                    case "red":
                        if (entry.getValue() > 12) return false;
                        break;
                    case "green":
                        if (entry.getValue() > 13) return false;
                        break;
                    case "blue":
                        if (entry.getValue() > 14) return false;
                        break;
                }
            }
        }
        return true;
    }

    int powerOfMinimumSet() {
        return minimumSet().power();
    }

    private CubeSet minimumSet() {

        var red = 0;
        var green = 0;
        var blue = 0;

        for (var reveal : reveals) {
            if (reveal.containsKey("red")) {
                red = Math.max(red, reveal.get("red"));
            }
            if (reveal.containsKey("green")) {
                green = Math.max(green, reveal.get("green"));
            }
            if (reveal.containsKey("blue")) {
                blue = Math.max(blue, reveal.get("blue"));
            }
        }

        return new CubeSet(red, green, blue);
    }
}
