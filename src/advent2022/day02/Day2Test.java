package advent2022.day02;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {
	String testdataPath = "src/advent2022/day2/testdata";

	@Test
	void test1() throws IOException {
		int result = Day2.part1(testdataPath);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day2.part2(testdataPath);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
