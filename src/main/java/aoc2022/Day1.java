package aoc2022;

import lib.AbsSolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ReaderUtil;

import java.io.BufferedReader;
import java.util.Comparator;

public class Day1 extends AbsSolution {
    private static Logger logger = LoggerFactory.getLogger(Day1.class);

    public static void main(String[] args) {
        new Day1().run();
    }

    @Override
    public void part1(BufferedReader reader) {
        int result = ReaderUtil
                .groupLines(reader, String::isEmpty)
                .mapToInt(groups -> groups.mapToInt(Integer::parseInt).sum())
                .max()
                .orElseThrow();
        log.info("Result {}", result);
    }

    @Override
    public void part2(BufferedReader reader) {
        int result = ReaderUtil
                .groupLines(reader, String::isEmpty)
                .map(groups -> groups.mapToInt(Integer::parseInt).sum())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(j -> j)
                .sum();
        log.info("Result {}", result);
    }
}
