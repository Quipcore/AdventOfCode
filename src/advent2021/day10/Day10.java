package advent2021.day10;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import datacollector.datacollector;

public class Day10 {

	private static Map<Character, Character> chunkPairs = Map.of('(', ')', '[', ']', '{', '}', '<', '>');
	private static Set<Character> startCharacter = Set.of('(', '[', '{', '<');
	private static Map<Character, Integer> charVal1 = Map.of(')',3,']',57,'}',1197,'>',25137);
	private static Map<Character, Integer> charVal2 = Map.of('(',1,'[',2,'{',3,'<',4);

	public static void main(String[] args) throws IOException {

		String puzzledata = "src/advent2021/day10/puzzledata";

		int result1 = part1(puzzledata);
		System.out.println("Test 1: " + result1);

		long result2 = part2(puzzledata);
		System.out.println("Test 2: " + result2);
	}

	// --------------------------------------------------------------------------------

	public static int part1(String puzzledata) throws IOException {

		return datacollector.getStream(puzzledata).map(s -> {

			Stack<Character> stk = new Stack<>();

			for (char c : s.toCharArray()) {
				if (startCharacter.contains(c)) {
					stk.push(c);
				} else {
					if (!chunkPairs.get(stk.peek()).equals(c)) {
						return charVal1.get(c);
					}
					stk.pop();
				}
			}
			return 0;
		}).reduce(0, (a, b) -> a + b);

	}


	// --------------------------------------------------------------------------------

	public static long part2(String puzzledata) throws IOException {

		List<Long> moddedList = datacollector.getStream(puzzledata).map(s -> {

			Stack<Character> stk = new Stack<>();
			
			for (char c : s.toCharArray()) {
				if (startCharacter.contains(c)) {
					stk.push(c);
				} else {
					if (!chunkPairs.get(stk.peek()).equals(c)) {
						return 0L;
					}
					stk.pop();
				}
			}
			
			long sum = 0;
			while (!stk.isEmpty()) {
				sum = 5 * sum + charVal2.get(stk.pop());
			}

			return sum;
		}).filter(v -> v != 0).sorted().collect(Collectors.toList());

		return moddedList.get(moddedList.size() / 2);

	}
}
