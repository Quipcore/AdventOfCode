package advent2021.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import datacollector.datacollector;

public class Day8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2021/day8/puzzledata";

		int result1 = part1(puzzledata);
		System.out.println("Test 1: " + result1);

		long result2 = part2(puzzledata);
		System.out.println("Test 2: " + result2);
	}

	public static int part1(String puzzledata) throws IOException {

		List<String> nums = datacollector.getList(puzzledata);
		return nums.stream().map(s -> s.split("\\|")[1]) // Split on "|" return every after
				.map(s -> {
					String[] arr = s.split(" ");
					int sum = 0;
					for (String str : arr) {
						if (Arrays.asList(2, 3, 4, 7).contains(str.length())) {
							sum++;
						}
					}
					return sum;
				}) // For every s get the number of wanted items
				.reduce(0, (a, b) -> a + b); // sum upp all rows

	}

	public static int part2(String puzzledata) throws IOException {
		List<String> nums = datacollector.getList(puzzledata);

		return nums.stream().map(s -> calcnum(s)).reduce(0, (a, b) -> a + b);

	}
	
	private static List<String> getShortList (List<String> longList){
		String commonChars = "";
		for (int i = 0; i < longList.get(0).length(); i++) {
			char c = longList.get(0).charAt(i);
			if (longList.stream().allMatch(str -> str.indexOf(c) != -1)) {
				commonChars += c;
			}
		}

		List<String> shortList = new ArrayList<>(longList);
		for (int i = 0; i < shortList.size(); i++) {
			for (int j = 0; j < commonChars.length(); j++) {

				String str = shortList.get(i).replace(Character.toString(commonChars.charAt(j)), "");
				shortList.set(i, str);
			}
		}
		return shortList;
	}
	
	
	private static int calcnum(String s) {
		String s0 = s.split("\\|")[0];
		String s1 = s.split("\\|")[1];
		List<String> uncodedValues = Arrays.asList(s0.split(" "));
		List<String> listOfFives = new ArrayList<>();
		List<String> listOfSixes = new ArrayList<>();
		String[] values = new String[10];

		for (String v : uncodedValues) {
			if (v.length() == 2) {
				values[1] = v;
			}
			if (v.length() == 4) {
				values[4] = v;
			}
			if (v.length() == 3) {
				values[7] = v;
			}
			if (v.length() == 7) {
				values[8] = v;
			}
			if (v.length() == 5) {
				listOfFives.add(v);
			}
			if (v.length() == 6) {
				listOfSixes.add(v);
			}
		}
		
		List<String> fiveShort = getShortList(listOfFives);
		
		int twoShortindex = 0;
		for (int i = 0; i < fiveShort.size(); i++) {
			List<Character> c = new ArrayList<>();
			for (char ch : fiveShort.get(i).toCharArray()) {

				c.add(ch);
			}

			if (c.stream().allMatch(ch -> values[1].contains(String.valueOf(ch)))) {
				values[3] = listOfFives.get(i);
			} else if (c.stream().allMatch(
					ch -> values[4].contains(String.valueOf(ch)) && values[8].contains(String.valueOf(ch)))) {
				values[5] = listOfFives.get(i);
			} else {
				values[2] = listOfFives.get(i);
				twoShortindex = i;
			}
		}
		
		final String twoShort = fiveShort.get(twoShortindex);
		List<String> sixShort = getShortList(listOfSixes);
		for (int i = 0; i < sixShort.size(); i++) {
			List<Character> c = new ArrayList<>();
			for (char ch : sixShort.get(i).toCharArray()) {

				c.add(ch);
			}

			if (c.stream().allMatch(ch -> values[3].contains(String.valueOf(ch)))) {
				values[9] = listOfSixes.get(i);
			} else if (c.stream().allMatch(
					ch -> twoShort.contains(String.valueOf(ch)))) {
				values[0] = listOfSixes.get(i);
			} else {
				values[6] = listOfSixes.get(i);
			}
		}
		
		int num = 0; //Problem in loop, output and input not in same order
		String[] strArr = s1.trim().split(" ");
		
		for(int i = 0; i < strArr.length; i++) {
			List<Character> c = new ArrayList<>();
			for (char ch : strArr[i].toCharArray()) {
				c.add(ch);
			}
			for(int j = 0; j < values.length; j++) {
				final int index = j;
				if(c.stream().allMatch(ch -> values[index].contains(String.valueOf(ch))) && (values[index].length() == strArr[i].length())) {
					num += (j * Math.pow(10, strArr.length-i-1));
					System.out.println(num);
				}
			}
		}
		
		/*
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
			for(int j = 0; j < values.length; j++) {
				if(strArr[i].equals(values[j])){
					num += (j * Math.pow(10, strArr.length-i-1));
					System.out.println("num+ " + num);
					break;
				}
			}
		}
		*/
		System.out.println();
		return num;
	}
	
}
