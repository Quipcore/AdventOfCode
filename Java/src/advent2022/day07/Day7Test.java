package advent2022.day07;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {
	final String TEST_DATA = "src/" + Day7.class.getPackageName().replace(".","/") + "/testdata";

	@Test
	void test1() throws Exception {
		int result = Day7.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(95437, result);
	}
	
	@Test
	void test2() throws Exception {
		int result = Day7.part2(TEST_DATA);
		System.out.println("Test 2: " + result);
		assertEquals(24933642, result);
	}

}
