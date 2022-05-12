package advent2021.day13;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Test {

    String testdots = "src/advent2021/day13/testdata_dots";
    String testfolds = "src/advent2021/day13/testdata_folds";
    @Test
    void test1() throws IOException {

        int result = Day13.part1(testdots,testfolds);
        System.out.println("Test 1: " + result);
        assertEquals(17, result);

    }

    @Test
    void test2() throws IOException {

        int result = Day13.part2(testdots,testfolds);
        System.out.println("Test 2: " + result);
        assertEquals(0, result);
    }
}
