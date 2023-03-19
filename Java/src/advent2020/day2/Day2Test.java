package advent2020.day2;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;


class Day2Test {
	
	private String testdata = "src/advent2020/day2/testdata";

	@Test
	void test1() throws IOException {
	
		int result = Day2.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(2, result);
	}
	
	@Test
	void test2() throws IOException {	
	
		int result = Day2.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(1, result);
	}

}
