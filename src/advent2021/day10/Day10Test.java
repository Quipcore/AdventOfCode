package advent2021.day10;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day10Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day10/testdata";		
	
		int result = Day10.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day10/testdata";	
		
	
		long result = Day10.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
