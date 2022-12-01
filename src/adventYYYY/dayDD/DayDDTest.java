package adventYYYY.dayDD;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayDDTest {
	String testdataPath = "src/adventYYYY/dayDD/testdata";

	@Test
	void test1() throws IOException {
		int result = DayDD.part1(testdataPath);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = DayDD.part2(testdataPath);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
