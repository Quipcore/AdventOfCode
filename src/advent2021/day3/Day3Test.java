package advent2021.day3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import datacollector.datacollector;

class Day3Test {

	@Test
	void test() throws IOException {
		String[] testData = datacollector.getStringArray("src/advent2021/day3/testdata"); 
		String result = Day3.run1(testData);
		assertEquals("198", result);
	}

}
