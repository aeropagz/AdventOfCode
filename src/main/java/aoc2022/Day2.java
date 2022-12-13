package aoc2022;

import lib.AbsSolution;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.util.function.IntBinaryOperator;

public class Day2 extends AbsSolution<Integer, Integer> {
    @Override
    public Integer part1(@NotNull BufferedReader reader) {
        return this.scoreStrategyGuide(
                reader,
                (p1, p2) -> {
                    var outcome = (p2 - p1 + 1 + 3) % 3;
                    return score(outcome, p2);

                });
    }

    @Override
    public Integer part2(@NotNull BufferedReader reader) {
        return this.scoreStrategyGuide(
                reader,
                (p1, outcome) -> {
                    var offset = outcome + 2;
                    var p2 = (p1 + offset) % 3;
                    return score(outcome, p2);
                });
    }

    public int scoreStrategyGuide(BufferedReader reader, IntBinaryOperator op) {
        return reader.lines()
                .mapToInt(line -> op.applyAsInt(line.charAt(0) - 'A', line.charAt(2) - 'X'))
                .sum();
    }

    public int score(int outcome, int player2Hand) {
        return outcome * 3 + player2Hand + 1;
    }

    public static void main(String[] args) {
        new Day2().run();
    }
}
