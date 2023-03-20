package advent2021.day3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import utils.datacollector;

class Day3Test {

	@Test
	void test() throws IOException {
		String[] testData = datacollector.getStringArray("src/advent2021/day3/testdata"); 
		int result = Day3.run1(testData);
		assertEquals(198, result);
	}

	@Test
	void test2() throws IOException{
		String[] testData = datacollector.getStringArray("src/advent2021/day3/inputdata");
		int result = Day3.run1(testData);
		assertEquals(2972336,result);
	}

}
