package advent2020.day4;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utils.datacollector;
public class Day4 {

	public static void main(String[] args) throws IOException {

		String puzzledata = "src/advent2020/day4/puzzledata";
		int result = part1(puzzledata);
		System.out.println("\nTest 1: " + result);

		result = part2(puzzledata);
		System.out.println("Test 2: " + result);
	}

	//-------------------------------------------------------------------------------------
	
	public static int part1(String puzzledata) throws IOException {
		List<String> passportInfo = datacollector.getList(puzzledata);

		LinkedList<Passport> passports = new LinkedList<>();
		
		int index = -1;
		while (index < passportInfo.size()) {
			String passportLine = "";
			index++;
			while (index < passportInfo.size() && !passportInfo.get(index).equals("")) {
				passportLine += passportInfo.get(index) + " ";
				index++;
			}
			System.out.println(passportLine);
			passports.add(new Passport(passportLine));
		}

		System.out.println("\nPassports Amounts " + passports.size());
		int validpassport = 0;
		for (Passport p : passports) {
			if (p.isValid()) {
				validpassport++;
			}
		}

		return validpassport;
	}

	//-------------------------------------------------------------------------------------
	
	public static int part2(String puzzledata) {

		return 0;
	}
}
