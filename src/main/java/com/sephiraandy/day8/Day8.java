package com.sephiraandy.day8;

import com.sephiraandy.util.Puzzle;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Day8 extends Puzzle<Long> {

    public static final String Z = "Z";

    public Day8() {
        this(s -> {});
    }

    public Day8(final Consumer<String> runTimeLogConsumer) {
        super(runTimeLogConsumer);
    }

    @Override
    public Long solve1(final String input) {
        final var startingPositions = new String[]{"AAA"};
        final Predicate<String[]> isComplete = nodes -> "ZZZ".equals(nodes[0]);
        return DesertMap.parse(input).traverse(isComplete, startingPositions);
    }

    @Override
    public Long solve2(final String input) {
        final var desertMap = DesertMap.parse(input);
        final var startingPositions = desertMap.startingPositions();
        return desertMap.traverse(Day8::allNodesEndInZ, startingPositions);
    }

    private static boolean allNodesEndInZ(final String[] nodes) {
        return Arrays.stream(nodes).allMatch(Day8::nodeEndsInZ);
    }

    private static boolean nodeEndsInZ(final String node) {
        return node.endsWith(Z);
    }
}
