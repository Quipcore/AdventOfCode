package advent2022.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {
	final String TEST_DATA = "java/src/" + Day11.class.getPackageName().replace(".","/") + "/testdata";

	@Test
	void test1() throws IOException {
		int result = Day11.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(10605, result);
	}
	
	@Test
	void test2() throws IOException {
		int result =  Day11.part2(TEST_DATA);
		System.out.println("Test 2: " + result);
		assertEquals("2713310158", result);
	}

}
