package aoc2022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    private Day3 instance;
    private BufferedReader reader;

    @BeforeEach
    void setup() {
        instance = new Day3();
        reader = instance.bufferedReader(this.getClass().getSimpleName());
    }

    @Test
    void testPart1() {
        Integer received = instance.part1(reader);
        assertThat(received).isEqualTo(157);
    }

    @Test
    void testPart2() {
        Integer received = instance.part2(reader);
        assertThat(received).isEqualTo(70);
    }
}
