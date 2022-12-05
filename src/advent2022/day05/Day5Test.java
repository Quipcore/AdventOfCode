package advent2022.day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {
	final String TEST_DATA = "src/" + Day5.class.getPackageName().replace(".","/") + "/testdata";
	final String TEST_STACK = "src/" + Day5.class.getPackageName().replace(".","/") + "/teststack";
	@Test
	void test1() throws IOException {
		String result = Day5.part1(TEST_DATA,TEST_STACK);
		System.out.println("Test 1: " + result);
		assertEquals("CMZ", result);
	}
	
	@Test
	void test2() throws IOException {
		String result = Day5.part2(TEST_DATA,TEST_STACK);
		System.out.println("Test 2: " + result);
		assertEquals("MCD", result);
	}

}
