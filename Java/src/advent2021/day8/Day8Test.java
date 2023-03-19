package advent2021.day8;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day8Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day8/testdata";		
	
		int result = Day8.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(26, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day8/testdata";	
		
	
		int result = Day8.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(61229, result);
	}

}
