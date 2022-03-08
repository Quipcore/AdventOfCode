package advent2021.day4;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Day4Test {

	@Test
	void test1() throws IOException {
		String tbrickFil = "src/advent2021/day4/testBrickor";
		String tnummerFil = "src/advent2021/day4/testNummer";
		String pbrickFil = "src/advent2021/day4/puzzleBrickor";
		String pnummerFil = "src/advent2021/day4/puzzleNummer";
		
	
		int result = Day4.part1(tbrickFil,tnummerFil);
		System.out.println("Test 1: " + result);
		assertEquals(4512, result);
	}
	
	@Test
	void test2() throws IOException {
		String tbrickFil = "src/advent2021/day4/testBrickor";
		String tnummerFil = "src/advent2021/day4/testNummer";
		String pbrickFil = "src/advent2021/day4/puzzleBrickor";
		String pnummerFil = "src/advent2021/day4/puzzleNummer";
		
	
		int result = Day4.part2(tbrickFil,tnummerFil);
		System.out.println("Test 2: " + result);
		assertEquals(1924, result);
	}

}
