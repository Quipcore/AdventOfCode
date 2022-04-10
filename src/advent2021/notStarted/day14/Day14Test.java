package advent2021.notStarted.day14;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day14Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day14/testdata";

		int result = Day14.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}

	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day14/testdata";

		int result = Day14.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
