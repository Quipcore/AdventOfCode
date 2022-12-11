package advent2022.day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
	final String TEST_DATA = "src/" + Day10.class.getPackageName().replace(".","/") + "/testdata";

	@Test
	void test1() throws IOException {
		int result = Day10.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(13140, result);
	}
	
	@Test
	void test2() throws IOException, InterruptedException {
		int result = Day10.part2(TEST_DATA);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
