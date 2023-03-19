package advent2022.day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {
	final String TEST_DATA_0 = "src/" + Day6.class.getPackageName().replace(".","/") + "/testdata";
	final String TEST_DATA_1 = "src/" + Day6.class.getPackageName().replace(".","/") + "/testdata_1";

	@Test
	void test1() throws IOException {
		int result = Day6.part1(TEST_DATA_0);
		System.out.println("Test 1_0: " + result);
		assertEquals(5, result);
	}

	@Test
	void test1_2() throws IOException {
		int result = Day6.part1(TEST_DATA_1);
		System.out.println("Test 1_1: " + result);
		assertEquals(6, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = Day6.part2(TEST_DATA_0);
		System.out.println("Test 2_0: " + result);
		assertEquals(23, result);
	}
	@Test
	void test2_1() throws IOException {
		int result = Day6.part2(TEST_DATA_1);
		System.out.println("Test 2_1: " + result);
		assertEquals(23, result);
	}

}
