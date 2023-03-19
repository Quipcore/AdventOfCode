package advent2022.day08;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Test {
	final String TEST_DATA = "src/" + Day8.class.getPackageName().replace(".","/") + "/testdata";

	@Test
	void test1() throws IOException {
		int result = Day8.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(21, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day8.part2(TEST_DATA);
		System.out.println("Test 2: " + result);
		assertEquals(8, result);
	}

}
