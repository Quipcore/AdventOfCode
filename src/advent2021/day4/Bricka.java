package advent2021.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bricka {
	class Element {
		private int num;
		private boolean checked = false;

		public Element(int num) {
			this.num = num;
		}

		public void setCheck() {
			checked = true;
		}

		public boolean isChecked() {
			return checked;
		}

		public int getNum() {
			return num;
		}
	}

	private Element[][] elements = new Element[5][5];

	public Bricka(List<String> rows) {
		for (int r = 0; r < 5; r++) {
			System.out.println(rows.get(r));
			List<String> ctemp = Arrays.asList(rows.get(r).split(" "));
			List<String> cols = ctemp.stream().filter(s -> !s.trim().isEmpty()).collect(Collectors.toList());

			Element[] e = new Element[5];
			for (int c = 0; c < 5; c++) {
				e[c] = new Element(Integer.parseInt(cols.get(c)));
			}
			elements[r] = e;
		}
	}

	// --------------------------------------------------------------

	public void checkNumber(int n) {
		for (int row = 0; row < 5; row++) {
			for (int cols = 0; cols < 5; cols++) {
				if (elements[row][cols].getNum() == n) {
					elements[row][cols].setCheck();
				}
			}
		}
	}

	// --------------------------------------------------------------

	public boolean isBingo() {
		for (int row = 0; row < 5; row++) {
			for (int cols = 0; cols < 5; cols++) {
				if (!elements[row][cols].isChecked()) {
					break;
				}
				if (cols == 4) {
					return true;
				}
			}
		}

		for (int cols = 0; cols < 5; cols++) {
			for (int row = 0; row < 5; row++) {
				if (!elements[row][cols].isChecked()) {
					break;
				}
				if (row == 4) {
					return true;
				}
			}
		}

		return false;
	}

	// --------------------------------------------------------------

	public int sumOfUnmarked() {
		int sum = 0;
		for (int cols = 0; cols < 5; cols++) {
			for (int row = 0; row < 5; row++) {
				if (!elements[row][cols].isChecked()) {
					sum += elements[row][cols].getNum();
				}
			}
		}
		return sum;
	}

}
