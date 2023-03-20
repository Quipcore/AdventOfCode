package advent2022.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {
	String testdataPath = "java/src/advent2022/day01/testdata";

	@Test
	void test1() throws IOException {
		int result = Day1.part1(testdataPath);
		System.out.println("Test 1: " + result);
		assertEquals(24000, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day1.part2(testdataPath);
		System.out.println("Test 2: " + result);
		assertEquals(45000, result);
	}

}
