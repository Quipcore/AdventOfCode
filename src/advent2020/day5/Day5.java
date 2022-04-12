package advent2020.day5;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import datacollector.datacollector;

public class Day5 {

	public static void main(String[] args) throws IOException {
		String puzzledata = "src/advent2020/day5/puzzledata";
		int result = part1(puzzledata);
		System.out.println("Test 1: " + result);

		result = part2(puzzledata);
		System.out.println("Test 2: " + result);

	}

	public static int part1(String puzzledata) throws IOException {

		List<Integer> seatIdList = getSeatList(puzzledata);
		return seatIdList.get(seatIdList.size() - 1);
	}

	// ------------------------------------------------------------------------------
	
	public static int part2(String puzzledata) throws IOException {
		List<Integer> seatIdList = getSeatList(puzzledata);
		for (int i = 0; i < seatIdList.size() - 1; i++) {
			if (seatIdList.get(i) - seatIdList.get(i + 1) != -1) {
				return seatIdList.get(i) + 1;
			}
		}
		return -1;
	}

	// ------------------------------------------------------------------------------
	
	private static List<Integer> getSeatList(String puzzledata) throws IOException {
		return datacollector.getStream(puzzledata).map(s -> {

			String row = s.split(String.valueOf(s.charAt(7)))[0];
			String col = "";
			for (int i = row.length(); i < s.length(); i++) {
				col += s.charAt(i);
			}

			int id = 8 * getVal(row, 'F', 127);

			return id += getVal(col, 'L', 7);

		}).sorted().collect(Collectors.toList());
	}

	// ------------------------------------------------------------------------------
	
	private static int getVal(String sequence, char lowDiv, int top) {
		int bot = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == lowDiv) {
				top = (top + bot) / 2;
			} else {
				bot = (top + bot) / 2 + 1;
			}
		}
		return top;
	}

}
