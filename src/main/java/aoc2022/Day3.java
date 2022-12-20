package aoc2022;

import lib.AbsSolution;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;

public class Day3 extends AbsSolution<Integer, Integer> {
    private static final int COMPARTMENTS = 2;
    private static final int GROUP_SIZE = 3;
    private static final int ALPHA_WIDTH = 'a' - 'A';

    @Override
    public Integer part1(@NotNull BufferedReader reader) {
        long[] masks = reader.lines()
                .<String>mapMulti((line, buffer) -> {
                    var compartmentSize = line.length() / COMPARTMENTS;
                    for (int i = 0; i < COMPARTMENTS; i++) {
                        var compartmentStart = i * compartmentSize;
                        buffer.accept(line.substring(compartmentStart, compartmentStart + compartmentSize));
                    }
                })
                .mapToLong(this::stringToMask)
                .toArray();

        return reduceAndMask(masks, COMPARTMENTS);
    }

    @Override
    public Integer part2(@NotNull BufferedReader reader) {
        long[] masks = reader.lines()
                .mapToLong(this::stringToMask)
                .toArray();

        return reduceAndMask(masks, GROUP_SIZE);
    }

    private long stringToMask(String s) {
        return s.chars()
                .mapToLong(c -> 1L << (c - 'a'))
                .reduce((acc, next) -> acc | next)
                .orElseThrow();
    }

    private int reduceAndMask(long[] masks, int chunkSize) {
        var sum = 0;
        for (var i = 0; i < masks.length; i += chunkSize) {
            var reducedMask = masks[i];
            for (var j = 1; j < chunkSize; j++) {
                reducedMask &= masks[i + j];
            }
            sum += calcPriority(reducedMask);
        }

        return sum;
    }

    private int calcPriority(long reducedMask) {
        var commonItem = Long.numberOfTrailingZeros(reducedMask);
        var upperOrLower = commonItem / ALPHA_WIDTH;

        return (commonItem % ALPHA_WIDTH) + 1 + upperOrLower * 26;
    }

    public static void main(String[] args) {
        new Day3().run();
    }
}
