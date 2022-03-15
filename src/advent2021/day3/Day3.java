package advent2021.day3;

import java.io.IOException;
import datacollector.datacollector;

public class Day3 {

	public static void main(String[] args) throws IOException {
		String[] inputdata = datacollector.getStringArray("src/advent2021/day3/inputdata");
		String result = run1(inputdata);
		System.out.println(result);
	}
	
	public static String run1(String[] inputdata) {
		int nollor = 0;
		int ettor = 0;
		String gamma = "";
		String epislon = "";

		for (int i = 0; i < inputdata[0].length(); i++) {
			for (int j = 0; j < inputdata.length; j++) {

				if (inputdata[j].charAt(i) == '0') {
					nollor++;
				} else {
					ettor++;
				}
			}

			if (nollor < ettor) {
				gamma += "1";
				epislon += "0";
			} else {
				gamma += "0";
				epislon += "1";
			}

			nollor = 0;
			ettor = 0;
		}
		int returnValue = Integer.parseInt(gamma,2)*Integer.parseInt(epislon,2);
		return String.valueOf(returnValue);
	}

	public static String run2(String[] inputdata) {
		return null;
	}
}
