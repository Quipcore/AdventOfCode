package adventYYYY.dayDD;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayDDTest {
	final String TEST_DATA = "src/" + DayDD.class.getPackageName().replace(".","/") + "/testdata";

	@Test
	void test1() throws IOException {
		int result = DayDD.part1(TEST_DATA);
		System.out.println("Test 1: " + result);
		assertEquals(0, result);
	}
	
	@Test
	void test2() throws IOException {
		int result = DayDD.part2(TEST_DATA);
		System.out.println("Test 2: " + result);
		assertEquals(0, result);
	}

}
