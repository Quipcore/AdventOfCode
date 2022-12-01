package adventYYYY.dayD;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayDTest {
	String testdataPath = "src/adventYYYY/dayD/testdata";

	@Test
	void test1() throws IOException {
		int result = DayD.part1(testdataPath);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = DayD.part2(testdataPath);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
