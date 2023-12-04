package com.sephiraandy.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Input {
    public static Stream<String> lineStream(String input) {
        return Arrays.stream(asLines(input));
    }

    public static String loadTextFromFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        final var bufferedReader = new BufferedReader(
            new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }

    public static String[] asLines(String input) {
        return input.split("\n");
    }
}
