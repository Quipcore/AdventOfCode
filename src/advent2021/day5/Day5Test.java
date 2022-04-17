package advent2021.day5;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day5Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day5/testdata";		
	
		int result = Day5.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(5, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day5/testdata";	
		
	
		int result = Day5.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(12, result);
	}

}
