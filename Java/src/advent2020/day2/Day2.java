package advent2020.day2;

import java.io.IOException;
import java.util.List;
import utils.DataCollector;

public class Day2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2020/day2/puzzledata";

		int result1 = part1(puzzledata);
		System.out.println("Test 1: " + result1);

		int result2 = part2(puzzledata);
		System.out.println("Test 2: " + result2);
	}

	public static int part1(String puzzledata) throws IOException {
		List<String> passwords = DataCollector.getList(puzzledata);

		return passwords.stream().map(s -> s.split(":")).map(s -> {

			int index = 0;
			String bot = "";
			while (s[0].charAt(index) != '-') {
				bot += s[0].charAt(index);
				index++;
			}
			index++;
			String roof = "";
			while (s[0].charAt(index) != ' ') {
				roof += s[0].charAt(index);
				index++;
			}

			int bottom = Integer.valueOf(bot);
			int top = Integer.valueOf(roof.trim());

			String letter = String.valueOf(s[0].charAt(s[0].length() - 1));
			String password = s[1];

			int count = password.length() - password.replaceAll(letter, "").length();

			if (bottom <= count && count <= top) {
				return 1;
			} else {
				return 0;
			}
		}).reduce(0, (a, b) -> a + b);

	}

	public static int part2(String puzzledata) throws IOException {
		List<String> passwords = DataCollector.getList(puzzledata);

		return passwords.stream().map(s -> s.split(":")).map(s -> {
			int index = 0;
			String bot = "";
			while (s[0].charAt(index) != '-') {
				bot += s[0].charAt(index);
				index++;
			}
			index++;
			String roof = "";
			while (s[0].charAt(index) != ' ') {
				roof += s[0].charAt(index);
				index++;
			}

			int bottom = Integer.valueOf(bot);
			int top = Integer.valueOf(roof.trim());

			char letter = s[0].charAt(s[0].length() - 1);
			String password = s[1].trim();


			if ((password.charAt(bottom-1) == letter) && (password.charAt(top-1) != letter)) {
				return 1;
			} else if((password.charAt(bottom-1) != letter) && (password.charAt(top-1) == letter)){
				return 1;
			}
			else {
				return 0;
			}
		}).reduce(0, (a, b) -> a + b);

	}

}
