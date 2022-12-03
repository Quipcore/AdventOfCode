package advent2022.day03;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {
	String testdataPath = "src/advent2022/day03/testdata";

	@Test
	void test1() throws IOException {
		int result = Day3.part1(testdataPath);
		System.out.println("Test 1: " + result);
		assertEquals(157, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day3.part2(testdataPath);
		System.out.println("Test 2: " + result);
		assertEquals(70, result);
	}

}
