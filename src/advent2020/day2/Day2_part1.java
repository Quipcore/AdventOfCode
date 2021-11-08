package advent2020.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day2_part1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String FilePath = "D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2020\\day2\\inputdata";
		File file = new File(FilePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";

		Path path = Paths.get(FilePath);
		int lineAmount = (int) Files.lines(path).count();

		String[] inputdata = new String[lineAmount];
		System.out.println("Amout of lines in file: " + inputdata.length);

		char letter ='\u0000';
		int letterAmount = 0;
		int ceiling = 1000;
		int floor = 0;
		int validpasswords = 0;

		for(int i = 0; i < inputdata.length; i++) {
			inputdata[i] = br.readLine();
			//System.out.println(inputdata[i]);
			for(int j = 0; j < inputdata[i].length(); j++){
				if(inputdata[i].charAt(j) == '-'){
					if(inputdata[i].charAt(j-1) >= 30 && inputdata[i].charAt(j-1) <=39){

						floor += inputdata[i].charAt(j-1);
						//Ascii kod för 0-9 är 30-39
					}
					if(true/**/){
						//get ceiling
					}
				}
				if(inputdata[i].charAt(j) == ':'){
					 letter = inputdata[i].charAt(j-1);
				}
				if(inputdata[i].charAt(j) == letter){
					letterAmount++;
				}
			}
			if(letterAmount < ceiling && letterAmount > floor){
				validpasswords++;
			}
		}
		System.out.println("validpasswords = " + validpasswords );

		fr.close();
	}

}
