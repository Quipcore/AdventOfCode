package advent2021.day6;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day6Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day6/testdata";		
	
		long result = Day6.part1(testdata, 80);
		System.out.println("Test 1: " + result);
		assertEquals(5934, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day6/testdata";	
		
	
		long result = Day6.part2(testdata, 256);
		System.out.println("Test 2: " + result);
		assertEquals(26984457539L, result);
	}

}
