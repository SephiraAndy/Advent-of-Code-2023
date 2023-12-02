package com.sephiraandy.util;

import java.util.Arrays;
import java.util.stream.Stream;

public class Input {
    public static Stream<String> lineStream(String input) {
        return Arrays.stream(input.split("\n"));
    }
}
