package aoc2022;

import lib.AbsSolution;

import java.io.BufferedReader;

public class Day2 extends AbsSolution<Integer, Integer> {
    @Override
    public Integer part1(BufferedReader reader) {
        return reader.lines()
                .map(line -> this.calcPointsPart1(line.charAt(0), line.charAt(2)))
                .mapToInt(i -> i)
                .sum();
    }

    @Override
    public Integer part2(BufferedReader reader) {
        return reader.lines()
                .mapToInt(this::calcPointsPart2)
                .sum();
    }

    public int calcPointsPart1(int p1, int p2) {
        //normalize
        p1 -= 'A';
        p2 -= 'X';
        var outcome = (p2 - p1 + 1 + 3) % 3;
        return score(outcome, p2);
    }

    public int score(int outcome, int p2) {
        return outcome * 3 + p2 + 1;
    }

    public int calcPointsPart2(String line) {
        String[] s = line.split(" ");
        switch (s[0]) {
            case "A":
                if (s[1].equals("X")) {
                    return 3;
                } else if (s[1].equals("Y")) {
                    return 4;
                } else if (s[1].equals("Z")) {
                    return 8;
                }
                break;
            case "B":
                if (s[1].equals("X")) {
                    return 1;
                } else if (s[1].equals("Y")) {
                    return 5;
                } else if (s[1].equals("Z")) {
                    return 9;
                }
                break;
            case "C":
                if (s[1].equals("X")) {
                    return 2;
                } else if (s[1].equals("Y")) {
                    return 6;
                } else if (s[1].equals("Z")) {
                    return 7;
                }
                break;
            default:
                throw new IllegalArgumentException("Parameter not 'A', 'B' or 'C', is: " + line);
        }
        throw new IllegalArgumentException("Parameter not 'X', 'Y' or 'Z', is: " + line);
    }

    public static void main(String[] args) {
        new Day2().run();
    }
}
