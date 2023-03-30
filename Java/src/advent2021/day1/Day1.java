package advent2021.day1;

import java.io.IOException;
import java.util.LinkedList;
import utils.DataCollector;

public class Day1 {

	public static void main(String[] args) throws IOException {

		int[] inputdata = DataCollector.getIntArray("java/src/advent2021/day1/inputdata");
		
		LinkedList<Integer> measurements = new LinkedList<>();
		for(int i = 0; i < inputdata.length-2; i++) {
			measurements.add(inputdata[i] + inputdata[i+1] + inputdata[i+2]);
		}
		
		int increase = 0;
		for(int j = 0; j < measurements.size()-1; j++) {
			if(measurements.get(j) < measurements.get(j+1)) {
				increase++;
			}
		}
		System.out.println(increase);
	}

}
