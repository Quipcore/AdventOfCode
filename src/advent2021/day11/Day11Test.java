package advent2021.day11;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day11/testdata";

		int result = Day11.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}

	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day11/testdata";

		int result = Day11.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
