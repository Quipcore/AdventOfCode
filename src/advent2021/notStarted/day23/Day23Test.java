package advent2021.notStarted.day23;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day23Test {

	@Test
	void test1() throws IOException {

		String testdata = "src/advent2021/day23/testdata";

		int result = Day23.part1(testdata);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}

	@Test
	void test2() throws IOException {
		String testdata = "src/advent2021/day23/testdata";

		int result = Day23.part2(testdata);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
