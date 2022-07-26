package advent2021.day14;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day14/testdata";
	
		int result = Day14.part1(testdata,"NNCB");
		System.out.println("Test 1: " + result);
		assertEquals(1588, result);
	}
	
	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day14/testdata";
		
		long result = Day14.part2(testdata,"NNCB");
		System.out.println("Test 2: " + result);
		assertEquals(1588L, result);
	}

}
