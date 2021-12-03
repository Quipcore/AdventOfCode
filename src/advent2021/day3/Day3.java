package advent2021.day3;

import java.io.IOException;

import datacollector.datacollector;

public class Day3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] inputdata = datacollector.datacollectorSTR("src/advent2021/day3/inputdata");

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
		System.out.println("GAMMA = " + gamma);
		System.out.println("Epsilon =  " + epislon);
		System.out.println("Power " + (Integer.parseInt(gamma,2)*Integer.parseInt(epislon,2)));
	}

}
