package advent2021.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day10/testdata";		
	
		int result = Day10.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(26397, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day10/testdata";	
		
		long result = Day10.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(288957, result);
	}

}
