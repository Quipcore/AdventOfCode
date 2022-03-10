package advent2021.day2;

import java.io.IOException;

import datacollector.datacollector;

public class Day2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] inputdata = datacollector.getStringArray("src/advent2021/day2/inputdata");

		int aim = 0;
		int Xpos = 0;
		int Ypos = 0;
		char XposS;
		char aimPos;
		
		for (int i = 0; i < inputdata.length; i++) {
			if (inputdata[i].contains("forward")) {
				XposS = inputdata[i].charAt(inputdata[i].length() - 1);
				Xpos += Character.getNumericValue(XposS);
				Ypos += Character.getNumericValue(XposS) * aim;
			} else if (inputdata[i].contains("up")) {
				aimPos = inputdata[i].charAt(inputdata[i].length() - 1);
				aim -= Character.getNumericValue(aimPos);
			} else if (inputdata[i].contains("down")) {
				aimPos = inputdata[i].charAt(inputdata[i].length() - 1);
				aim += Character.getNumericValue(aimPos);
			}
		}
		System.out.println(Xpos*Ypos);
		System.out.println();
	}
}
