package advent2020.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1_part2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		File file = new File("D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2020\\InputDay1");
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
		for (int i = 0; i < inputdata.length; i++) {
			for (int j = 0; j < inputdata.length; j++) {
				for (int k = 0; k < inputdata.length; k++) {
					summa = inputdata[i] + inputdata[j] + inputdata[k];
					if (summa == 2020) {
						produkt = inputdata[i] * inputdata[j] * inputdata[k];
						System.out.println(inputdata[i] + " + " + inputdata[j] + " + " + inputdata[k] + " = " + summa);
						System.out.println(inputdata[i] + " * " + inputdata[j] + " * " + inputdata[k] +  " = " + produkt);
						br.close();
						return;
					}
				}
			}
		}
	}

}
