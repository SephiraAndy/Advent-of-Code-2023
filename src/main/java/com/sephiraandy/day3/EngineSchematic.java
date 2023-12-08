package com.sephiraandy.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class EngineSchematic {
    private final SchematicLine[] schematic;

    public static EngineSchematic parse(String input) {
        final var schematicLines = input.split("\n");
        final var schematic = new SchematicLine[schematicLines.length];
        for (var i = 0; i < schematicLines.length; ++i) {
            schematic[i] = new SchematicLine(schematicLines[i]);
        }
        return new EngineSchematic(schematic);
    }

    private EngineSchematic(SchematicLine[] schematic) {
        this.schematic = schematic;
    }

    public Collection<Integer> getPartNumbers() {
        return IntStream.range(0, schematic.length)
            .mapToObj(this::getPartsFromLine)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    private Collection<Integer> getPartsFromLine(final int lineNumber) {
        final var partNumbers = new ArrayList<Integer>();

        final var line = schematic[lineNumber];
        for (int position = 0; position < line.length(); ++position) {
            if (line.isDigitAt(position)) {
                var numberString = line.extractNumberStringStartingAt(position);
                if (isEnginePartNumber(numberString, position, lineNumber)) {
                    partNumbers.add(Integer.parseInt(numberString));
                }
                position += numberString.length() - 1;
            }

        }
        return partNumbers;
    }

    private boolean isEnginePartNumber(String numberString, int position, int lineNumber) {
        var lineFrom = Math.max(0, lineNumber - 1);
        var lineTo = Math.min(schematic.length - 1, lineNumber + 1);

        var positionFrom = Math.max(0, position - 1);
        var positionTo = Math.min(schematic[0].length() - 1, position + numberString.length());

        return IntStream.rangeClosed(lineFrom, lineTo)
            .mapToObj(line -> schematic[line])
            .anyMatch(schematicLine -> schematicLine.hasSymbolInRangeClosed(positionFrom, positionTo));
    }

    public Collection<Gear> getGears() {
        return IntStream.range(0, schematic.length)
            .mapToObj(this::getGearsFromLine)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    private Collection<? extends Gear> getGearsFromLine(final int lineNumber) {
        var gears = new ArrayList<Gear>();
        final var line = schematic[lineNumber];
        for (var position = 0; position < line.length(); ++position) {
            if (!line.gearSymbolAt(position)) {
                continue;
            }
            findGearAt(position, lineNumber).ifPresent(gears::add);
        }

        return gears;
    }

    private Optional<Gear> findGearAt(final int gearPosition,
                                      final int lineNumber) {
        final var partNumbers = new ArrayList<String>();
        final var lineFrom = Math.max(0, lineNumber - 1);
        final var lineTo = Math.min(schematic.length - 1, lineNumber + 1);
        final var positionFrom = Math.max(0, gearPosition - 1);
        final var positionTo = Math.min(schematic[0].length() - 1, gearPosition + 1);

        for (var line = lineFrom; line <= lineTo; ++line) {
            final var schematicLine = schematic[line];
            for (var position = positionFrom; position <= positionTo; ++position) {
                if (schematicLine.isDigitAt(position)) {
                    if (partNumbers.size() == 2) {
                        return Optional.empty();
                    }

                    final var partNumberStart = schematicLine.getStartPositionOfPartNumberContaining(position);
                    final var partNumberString = schematicLine.extractNumberStringStartingAt(partNumberStart);

                    partNumbers.add(partNumberString);
                    position = partNumberStart + partNumberString.length() - 1;
                }
            }
        }

        return partNumbers.size() == 2
            ? Optional.of(new Gear(Integer.parseInt(partNumbers.get(0)), Integer.parseInt(partNumbers.get(1))))
            : Optional.empty();
    }
}
