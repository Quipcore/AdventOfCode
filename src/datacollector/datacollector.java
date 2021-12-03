package datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class datacollector {

	public static int[] datacollectorINT(String URL) throws IOException {
		File file = new File(URL);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		LinkedList<Integer> inputlist = new LinkedList<>();
		
		while ((line = br.readLine()) != null) {
			inputlist.add(Integer.valueOf(line));
		}
		
		int[] inputdata = new int[inputlist.size()];
		for (int count = 0; count < inputdata.length; count++) {
			inputdata[count] = inputlist.get(count);
		}
		
		fr.close();

		return inputdata;
	}

	public static String[] datacollectorSTR(String URL) throws IOException{
			File file = new File(URL);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			LinkedList<String> inputlist = new LinkedList<>();
			
			while ((line = br.readLine()) != null) {
				inputlist.add(line);
			}
			
			String[] inputdata = inputlist.toArray(new String[inputlist.size()]);
			fr.close();
				
			return inputdata;	
	}
}
