package advent2021.day9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import datacollector.datacollector;

public class Day9 {

	private static List<Integer> alreadyChecked = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2021/day9/puzzledata";

		int result1 = part1(puzzledata);
		System.out.println("Test 1: " + result1);

		int result2 = part2(puzzledata);
		System.out.println("Test 2: " + result2);
	}

	// --------------------------------------------------------------------------------

	public static int part1(String puzzledata) throws IOException {

		int[][] map = createMap(puzzledata);
		int sum = 0;

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				int mapPoint = map[row][col];
				int up = (row == 0) ? 10 : map[row - 1][col];
				int down = (row == map.length - 1) ? 10 : map[row + 1][col];
				int left = (col == 0) ? 10 : map[row][col - 1];
				int right = (col == map[0].length - 1) ? 10 : map[row][col + 1];

				if (mapPoint < up && mapPoint < down && mapPoint < right && mapPoint < left) {
					sum += mapPoint + 1;
				}
			}
		}

		return sum;
	}

	// --------------------------------------------------------------------------------

	public static int part2(String puzzledata) throws IOException {
		int[][] map = createMap(puzzledata);
		List<Integer> lowPointSizes = new ArrayList<>();

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				int mapPoint = map[row][col];
				int up = (row == 0) ? 10 : map[row - 1][col];
				int down = (row == map.length - 1) ? 10 : map[row + 1][col];
				int left = (col == 0) ? 10 : map[row][col - 1];
				int right = (col == map[0].length - 1) ? 10 : map[row][col + 1];

				if (mapPoint < up && mapPoint < down && mapPoint < right && mapPoint < left) {

					lowPointSizes.add(findSizeOfBasin(row, col, map));
				}
			}
		}
		
		lowPointSizes = lowPointSizes.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


		return lowPointSizes.get(0) * lowPointSizes.get(1) * lowPointSizes.get(2);
	}

	// --------------------------------------------------------------------------------

	private static int[][] createMap(String puzzledata) throws IOException {

		List<String> input = datacollector.getList(puzzledata);

		int map[][] = new int[input.size()][input.get(0).length()];

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				map[row][col] = Integer.valueOf(String.valueOf(input.get(row).charAt(col)));
				// System.out.print(map[row][col]);
			}
			// System.out.println();
		}

		return map;
	}

	// --------------------------------------------------------------------------------

	private static int findSizeOfBasin(int row, int col, int[][] map) {
		int size = 1;
		setAlreadyChecked(row, col);

		if (row != 0 && map[row - 1][col] != 9 && !isAlreadyChecked(row - 1, col)) {
			size = size + findSizeOfBasin(row - 1, col, map);
		}
		if (col != 0 && map[row][col - 1] != 9 && !isAlreadyChecked(row, col - 1)) {
			size = size + findSizeOfBasin(row, col - 1, map);
		}
		if (row != map.length - 1 && map[row + 1][col] != 9 && !isAlreadyChecked(row + 1, col)) {
			size = size + findSizeOfBasin(row + 1, col, map);
		}
		if (col != map[0].length - 1 && map[row][col + 1] != 9 && !isAlreadyChecked(row, col + 1)) {
			size = size + findSizeOfBasin(row, col + 1, map);
		}

		return size;
	}

	private static void setAlreadyChecked(int row, int col) {
		alreadyChecked.add(row * 1000 + col);
	}

	private static boolean isAlreadyChecked(int row, int col) {

		return alreadyChecked.contains(row * 1000 + col);
	}

}
