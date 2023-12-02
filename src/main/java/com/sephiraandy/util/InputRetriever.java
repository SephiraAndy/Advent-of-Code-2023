package com.sephiraandy.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputRetriever {

    public static String get(String filePath) throws IOException {
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
}