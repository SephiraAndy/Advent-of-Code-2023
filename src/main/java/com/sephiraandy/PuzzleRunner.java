package com.sephiraandy;

import com.sephiraandy.day1.Day1;
import com.sephiraandy.day2.Day2;
import com.sephiraandy.day3.Day3;
import com.sephiraandy.day4.Day4;
import com.sephiraandy.day5.Day5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PuzzleRunner {
    public static void main(String[] args) throws IOException {

        final var reportBuilder = new StringBuilder("# Run Times\n\n");

        reportBuilder.append("## Day 1\n\n```\n");
        new Day1(reportBuilder::append).solve("input/Day1");
        reportBuilder.append("```\n\n");
        reportBuilder.append("## Day 2\n\n```\n");
        new Day2(reportBuilder::append).solve("input/Day2");
        reportBuilder.append("```\n\n");
        reportBuilder.append("## Day 3\n\n```\n");
        new Day3(reportBuilder::append).solve("input/Day3");
        reportBuilder.append("```\n\n");
        reportBuilder.append("## Day 4\n\n```\n");
        new Day4(reportBuilder::append).solve("input/Day4");
        reportBuilder.append("```\n\n");
        reportBuilder.append("## Day 5\n\n```\n");
        new Day5(reportBuilder::append).solve("input/Day5");
        reportBuilder.append("```\n\n");

        try (final var fileWriter = new FileWriter(new File("RunTimes.md"))) {
            fileWriter.write(reportBuilder.toString());
        }
    }
}
