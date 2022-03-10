package advent2021.day5;

public class LineSegment {

	private int maxValue;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	// x1,y1 -> x2,y2
	public LineSegment(String row) {
		String[] coords = row.replace(" -> ", ",").split(",");
		x1 = Integer.valueOf(coords[0]);
		y1 = Integer.valueOf(coords[1]);
		x2 = Integer.valueOf(coords[2]);
		y2 = Integer.valueOf(coords[3]);
		maxValue = Math.max(x1, x2);
		maxValue = Math.max(maxValue, y1);
		maxValue = Math.max(maxValue, y2);
		maxValue++;
	}

	public void markPoints(int[][] grid) {

		if (x1 == x2 || y1 == y2) {
			if (x1 == x2) {
				for (int ypos = Math.min(y1, y2); ypos <= Math.max(y1, y2); ypos++) {
					grid[x1][ypos]++;
				}
			} else {
				for (int xpos = Math.min(x1, x2); xpos <= Math.max(x1, x2); xpos++) {
					grid[xpos][y1]++;
				}
			}
		}
		// return grid;
	}

	public int[][] markpoints45deg(int[][] grid) {

		if (x1 == x2 || y1 == y2) {
			if (x1 == x2) {
				for (int ypos = Math.min(y1, y2); ypos <= Math.max(y1, y2); ypos++) {
					grid[x1][ypos]++;
				}
			} else {
				for (int xpos = Math.min(x1, x2); xpos <= Math.max(x1, x2); xpos++) {
					grid[xpos][y1]++;
				}
			}
		} else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			int x = x1;
			int y = y1;
			while (x != x2) {
				grid[x][y]++;

				x = x1 < x2 ? x + 1 : x - 1;
				y = y1 < y2 ? y + 1 : y - 1;
			}
			grid[x][y]++;
		}
		return grid;
	}

	public int getMaxValue() {
		return maxValue;
	}

}
