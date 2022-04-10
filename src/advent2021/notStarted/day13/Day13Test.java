package advent2021.notStarted.day13;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day13Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day13/testdata";		
	
		int result = Day13.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day13/testdata";	
	
		int result = Day13.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
