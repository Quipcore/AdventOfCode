package advent2021.day6;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import datacollector.datacollector;

public class Day6 {
	class Fish {
		int age;

		public Fish(int age) {
			this.age = age;
		}

		public void setAge(int i) {
			age = i;
		}

		public int getAge() {
			return age;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2021/day6/puzzledata";

		//long result = part1(puzzledata_dots, 80);
		//System.out.println("Test 1: " + result);

		long result = part2(puzzledata, 256);
		System.out.println("Test 2: " + result);
	}

	public static long part1(String puzzledata, int days) throws IOException {

		String line = datacollector.getFirstLine(puzzledata);
		LinkedList<Integer> fisk = Arrays.asList(line.split(",")).stream().map(s -> Integer.valueOf(s)).collect(
				() -> new LinkedList<>(), (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));

		int newFishes = 0;
		//System.out.println("Hello");
		for (int i = 0; i < days; i++) {
			System.out.println(i);
			for (int index = 0; index < fisk.size(); index++) {
				int n = fisk.get(index);
				n--;
				if (n < 0) {
					newFishes++;
					n = 6;
				}
				fisk.set(index, n);
			}
			for (int k = 0; k < newFishes; k++) {
				fisk.add(8);
			}
			newFishes = 0;
		}

		return fisk.size();
	}

	public static long part2(String puzzledata, int days) throws IOException {

		long[] fishAges = new long[9];
		String[] input = datacollector.getFirstLine(puzzledata).split(",");

		for (String s : input) {
			fishAges[Integer.valueOf(s)]++;
		}

		for (int day = 0; day < days; day++) {
			long fishesWithZero = fishAges[0];
			for (int i = 0; i < fishAges.length; i++) {
				if (i == 6) {
					fishAges[6] = fishAges[7] + fishesWithZero;
				} else if (i == 8) {
					fishAges[8] = fishesWithZero;
				} else {
					fishAges[i] = fishAges[i + 1];
				}
			}
			//System.out.println(day);
		}

		long sum = 0;
		for (int i = 0; i < fishAges.length; i++) {
			sum += fishAges[i];
		}

		return sum;
	}

}
