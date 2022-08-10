package advent2020.day6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {

    @Test
    void test1() throws IOException {

        String testdata = "src/advent2020/day6/testdata";

        int result = Day6.part1(testdata);
        System.out.println("Test 1: " + result);
        assertEquals(11, result);
    }

    @Test
    void test2() throws IOException {
        String testdata = "src/advent2020/day6/testdata";

        long result = Day6.part2(testdata);
        System.out.println("Test 2: " + result);
        assertEquals(6, result);
    }

}
