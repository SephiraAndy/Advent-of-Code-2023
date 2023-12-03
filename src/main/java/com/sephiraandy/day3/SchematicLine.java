package com.sephiraandy.day3;

import java.util.stream.IntStream;

public class SchematicLine {
    private final String schematicLine;

    SchematicLine(String schematicLine) {
        this.schematicLine = schematicLine;
    }

    int getStartPositionOfPartNumberContaining(final int position) {
        var start = position;

        for (var i = position - 1; i >= 0; --i) {
            final var c = schematicLine.charAt(i);
            if (!Character.isDigit(c)) {
                return start;
            }
            start = i;
        }

        return start;
    }

    String extractNumberStringStartingAt(int start) {
        for (var position = start; position < schematicLine.length(); ++position) {
            final var c = schematicLine.charAt(position);
            if (Character.isDigit(c)) {
                continue;
            }
            return schematicLine.substring(start, position);
        }
        return schematicLine.substring(start);
    }

    int length() {
        return schematicLine.length();
    }

    boolean isDigitAt(int position) {
        return Character.isDigit(schematicLine.charAt(position));
    }

    private boolean isSymbolAt(int position) {
        final var c = schematicLine.charAt(position);
        return !Character.isDigit(c) && c != '.';
    }

    boolean gearSymbolAt(int position) {
        return schematicLine.charAt(position) == '*';
    }

    boolean hasSymbolInRangeClosed(int positionFrom, int positionTo) {
        return IntStream.rangeClosed(positionFrom, positionTo).anyMatch(this::isSymbolAt);
    }
}
