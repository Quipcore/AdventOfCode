package advent2020.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Day1_part1{
	
	//https://adventofcode.com/2020/day/1
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2020\\day1\\InputDay1");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int[] inputdata = new int[200];
		int c = 0;
		while ((line = br.readLine()) != null) {
			inputdata[c] = Integer.valueOf(line);
			c++;		
		}
		fr.close();
		
		int summa = 0;
		int produkt = 0;
		for(int i = 0; i < inputdata.length; i++) {
			for(int j = 0; j < inputdata.length; j++)
			{
				summa = inputdata[i] + inputdata[j];
				if (summa == 2020) {
					produkt = inputdata[i]*inputdata[j];
					System.out.println(inputdata[i] + " + " + inputdata[j] + " = " + summa);
					System.out.println(inputdata[i] + " * " + inputdata[j] + " = " + produkt);
					br.close();
					return;
				}
			}
		}
		
		
	}

}
