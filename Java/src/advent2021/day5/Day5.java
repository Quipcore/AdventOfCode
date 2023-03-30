package advent2021.day5;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utils.DataCollector;

public class Day5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2021/day5/puzzledata";
		int result = part1(puzzledata);
		System.out.println("Test 1: " + result);

		result = part2(puzzledata);
		System.out.println("Test 2: " + result);
	}

	public static int part1(String puzzledata) throws IOException {
		// TODO Auto-generated method stub
		List<String> coords = DataCollector.getList(puzzledata);

		List<LineSegment> lines = new LinkedList<>();
		int maxVal = 0;
		for (String c : coords) {
			LineSegment seg = new LineSegment(c);
			lines.add(seg);
			maxVal = Math.max(maxVal, seg.getMaxValue());
		}

		int[][] grid = new int[maxVal][maxVal];

		for (LineSegment s : lines) {
			s.markPoints(grid);
		}

		int overlaps = 0;
		for (int row = 0; row < maxVal; row++) {
			for (int col = 0; col < maxVal; col++) {
				if (grid[row][col] > 1) {
					overlaps++;
				}
			}
		}

		return overlaps;
	}

	public static int part2(String puzzledata) throws IOException {
		// TODO Auto-generated method stub
		List<String> coords = DataCollector.getList(puzzledata);

		List<LineSegment> lines = new LinkedList<>();
		int maxVal = 0;
		for (String c : coords) {
			LineSegment seg = new LineSegment(c);
			lines.add(seg);
			maxVal = Math.max(maxVal, seg.getMaxValue());
		}

		int[][] grid = new int[maxVal][maxVal];

		for (LineSegment s : lines) {
			grid = s.markpoints45deg(grid);
		}

		int overlaps = 0;
		for (int row = 0; row < maxVal; row++) {
			for (int col = 0; col < maxVal; col++) {
				if (grid[row][col] > 1) {
					overlaps++;
				}
			}
		}

		return overlaps;
	}

}
