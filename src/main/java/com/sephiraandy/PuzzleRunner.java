package com.sephiraandy;

import com.sephiraandy.day1.Day1;
import com.sephiraandy.day2.Day2;
import com.sephiraandy.day3.Day3;
import com.sephiraandy.day4.Day4;
import com.sephiraandy.day5.Day5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class PuzzleRunner {
    public static void main(String[] args) throws IOException {

        final var reportBuilder = new StringBuilder("# Run Times\n");

        log(reportBuilder, 1, new Day1(reportBuilder::append)::solve);
        log(reportBuilder, 2, new Day2(reportBuilder::append)::solve);
        log(reportBuilder, 3, new Day3(reportBuilder::append)::solve);
        log(reportBuilder, 4, new Day4(reportBuilder::append)::solve);
        log(reportBuilder, 5, new Day5(reportBuilder::append)::solve);

        try (final var fileWriter = new FileWriter(new File("RunTimes.md"))) {
            fileWriter.write(reportBuilder.toString());
        }
    }

    private static void log(StringBuilder reportBuilder, int day, Consumer<String> puzzle) {
        reportBuilder.append("\n## Day ").append(day).append("\n\n```\n");
        puzzle.accept("input/Day" + day);
        reportBuilder.append("```\n");
    }
}