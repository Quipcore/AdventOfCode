package advent2021.notStarted.day18;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day18Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day18/testdata";

		int result = Day18.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}

	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day18/testdata";

		int result = Day18.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
