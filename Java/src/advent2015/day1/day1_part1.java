package advent2015.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day1_part1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String FilePath = "D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2015\\day1\\inputdata";
		File file = new File(FilePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		
		line = br.readLine();
		int floor = 0;
		String test;
		Boolean firstbasement = true;
		int basmentindex = 0;
		for(int i = 0; i < line.length(); i++) {
			test = String.valueOf(line.charAt(i));
			if(test.equals("(")) {
				floor++;
			}
			else if (test.equals(")")) {
				floor--;
			}
			
			if(floor < 0 && firstbasement) {
				
				basmentindex = i+1;
				firstbasement = false;
			}
		}
		System.out.println(basmentindex);
		System.out.println(floor);
		
		fr.close();
	}

}
