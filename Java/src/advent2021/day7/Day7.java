package advent2021.day7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import datacollector.datacollector;

public class Day7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2021/day7/puzzledata";

		int result = part1(puzzledata);
		System.out.println("Test 1: " + result);

		result = part2(puzzledata);
		System.out.println("Test 2: " + result);

	}

	public static int part1(String puzzledata) throws IOException {
		return part(puzzledata, new Cost1());
	}

	public static int part2(String puzzledata) throws IOException {

		return part(puzzledata, new Cost2());
	}

	private static int part(String puzzledata, Cost cost) throws IOException {
		
		String line = datacollector.getFirstLine(puzzledata);
		LinkedList<Integer> crabs = Arrays.asList(line.split(",")).stream().map(s -> Integer.valueOf(s)).collect(
				() -> new LinkedList<>(), (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));
		Collections.sort(crabs);

		int prevSum = 0;

		for (int i = 0; i < crabs.get(crabs.size() - 1); i++) {

			final int x = i;
			int sum = crabs.stream().reduce(0, (a, b) -> a + cost.calc(Math.abs(b - x))); // sum from 0 -> n = n(n+1)/2

			System.out.println("i = " + i + ", sum = " + sum);
			if (sum > prevSum && prevSum > 0) {
				break;
			}
			prevSum = sum;
		}

		return prevSum;
	}

}
