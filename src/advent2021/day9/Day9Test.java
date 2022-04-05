package advent2021.day9;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day9Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day9/testdata";		
	
		int result = Day9.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(26, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day9/testdata";	
		
	
		long result = Day9.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(26, result);
	}

}
