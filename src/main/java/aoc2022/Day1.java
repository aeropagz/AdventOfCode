package aoc2022;

import lib.AbsSolution;
import util.ReaderUtil;

import java.io.BufferedReader;
import java.util.Comparator;

public class Day1 extends AbsSolution<Integer, Integer> {
    public static void main(String[] args) {
        new Day1().run();
    }

    @Override
    public Integer part1(BufferedReader reader) {
        return ReaderUtil
                .groupLines(reader, String::isEmpty)
                .mapToInt(groups -> groups.mapToInt(Integer::parseInt).sum())
                .max()
                .orElseThrow();
    }

    @Override
    public Integer part2(BufferedReader reader) {
        return ReaderUtil
                .groupLines(reader, String::isEmpty)
                .map(groups -> groups.mapToInt(Integer::parseInt).sum())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(j -> j)
                .sum();
    }
}
