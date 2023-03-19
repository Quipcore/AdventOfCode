package advent2022.day09;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {
	final String TEST_DATA = "src/" + Day9.class.getPackageName().replace(".","/") + "/testdata";
	final String TEST_DATA_LARGE = "src/" + Day9.class.getPackageName().replace(".","/") + "/testdata_large";
	@Test
	void test1() throws IOException {
		int result = Day9.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(13, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day9.part2(TEST_DATA_LARGE);
		System.out.println("Test 2: " + result);
		assertEquals(36, result);
	}

}
