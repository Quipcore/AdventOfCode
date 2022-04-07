package advent2015.day2;

import java.io.IOException;
import java.util.List;

import datacollector.datacollector;

public class Day2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String puzzledata = "src/advent2015/day2/puzzledata";

		int result = part1(puzzledata);
		System.out.println("Test 1: " + result);

		result = part2(puzzledata);
		System.out.println("Test 2: " + result);
	}
	
	public static int part1(String puzzledata) throws IOException {
		
		List<String> dimensions = datacollector.getList(puzzledata);
		
		return dimensions.stream().map(s -> s.split("x")).map(s ->{
			int sqrFeet = 0;
			int length = Integer.valueOf(s[0]);
			int width = Integer.valueOf(s[1]);
			int height = Integer.valueOf(s[2]);
			
			int min = Math.min(width*length, length*height);
			min = Math.min(height*width, min);
			sqrFeet += min;
			
			sqrFeet += (2*width*length + 2*width*height + 2*height*length);
			
			return sqrFeet;
		}).reduce(0, (a,b) -> a+b);
		
	}
	
	public static int part2(String puzzledata) throws IOException {
		
		List<String> dimensions = datacollector.getList(puzzledata);
		
		return dimensions.stream().map(s -> s.split("x")).map(s ->{
			int ribbonLength = 0;
			int length = Integer.valueOf(s[0]);
			int width = Integer.valueOf(s[1]);
			int height = Integer.valueOf(s[2]);
			
			int max = Math.max(height, width);
			max = Math.max(max, length);
			
			ribbonLength = 2*(height+width+length-max);
			
			ribbonLength += length*width*height;
			return ribbonLength;
		}).reduce(0, (a,b) -> a+b);
	}



}
