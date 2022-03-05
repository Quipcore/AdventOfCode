package datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

	public static String[] datacollectorSTR(String url) throws IOException {

		List<String> inputList = datacollectorListSTR(url);
		String[] inputdata = inputList.toArray(new String[inputList.size()]);

		return inputdata;
	}

	public static List<String> datacollectorListSTR(String url) throws IOException {
		File file = new File(url);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		List<String> inputlist = new LinkedList<>();

		while ((line = br.readLine()) != null) {
			inputlist.add(line);
		}

		fr.close();

		return inputlist;
	}
}
