package advent2021.day12;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {

	String testdata = "advent2021/day12/testdata";
	String testdata1 = "advent2021/day12/testdata1";
	String testdata2 = "advent2021/day12/testdata2";

	@Test
	void test1() throws IOException {

		int result = Day12.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(10, result);

		int result1 = Day12.part1(testdata1);
		System.out.println("Test 1: " + result1);
		assertEquals(19, result1);

		int result2 = Day12.part1(testdata2);
		System.out.println("Test 1: " + result2);
		assertEquals(226, result2);
	}

	@Test
	void test2() throws IOException {

		int result = Day12.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(36, result);

		int result1 = Day12.part2(testdata1);
		System.out.println("Test 2: " + result1);
		assertEquals(103, result1);

		int result2 = Day12.part2(testdata2);
		System.out.println("Test 2: " + result2);
		assertEquals(3509, result2);
	}

}
