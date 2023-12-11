package com.sephiraandy;

import com.sephiraandy.day1.Day1;
import com.sephiraandy.day10.Day10;
import com.sephiraandy.day11.Day11;
import com.sephiraandy.day2.Day2;
import com.sephiraandy.day3.Day3;
import com.sephiraandy.day4.Day4;
import com.sephiraandy.day5.Day5;
import com.sephiraandy.day6.Day6;
import com.sephiraandy.day7.Day7;
import com.sephiraandy.day8.Day8;
import com.sephiraandy.day9.Day9;

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
        log(reportBuilder, 6, new Day6(reportBuilder::append)::solve);
        log(reportBuilder, 7, new Day7(reportBuilder::append)::solve);
        log(reportBuilder, 8, new Day8(reportBuilder::append)::solve);
        log(reportBuilder, 9, new Day9(reportBuilder::append)::solve);
        log(reportBuilder, 10, new Day10(reportBuilder::append)::solve);
        log(reportBuilder, 11, new Day11(reportBuilder::append)::solve);

        try (final var fileWriter = new FileWriter("RunTimes.md")) {
            fileWriter.write(reportBuilder.toString());
        }
    }

    private static void log(StringBuilder reportBuilder, int day, Consumer<String> puzzle) {
        reportBuilder.append("\n### Day ").append(day).append("\n\n```\n");
        puzzle.accept("input/Day" + day);
        reportBuilder.append("```\n");
    }
}
