package advent2021.day7;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day7Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day7/testdata";		
	
		int result = Day7.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(37, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day7/testdata";	
		
	
		int result = Day7.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(168, result);
	}

}
