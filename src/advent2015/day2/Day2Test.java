package advent2015.day2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;


@SuppressWarnings("unused")
class Day2Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2015/day2/testdata";		
	
		int result = Day2.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2015/day2/testdata";	
		
	
		int result = Day2.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
