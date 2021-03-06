package advent2020.day4;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day4Test {

	@Test
	void test1() throws IOException {
		String testdata = "src/advent2020/day4/testdata";
	
		int result = Day4.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(2, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2020/day4/testdata";
				
		int result = Day4.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
