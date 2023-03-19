package advent2020.day5;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day5Test {
	
	//Testing done after completing challenge
	String testdata = "src/advent2020/day5/testdata";

	@Test
	void test1() throws IOException {

		int result = Day5.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(11, result);
	}

	@Test
	void test2() throws IOException {

		int result = Day5.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(120, result);
	}
}
