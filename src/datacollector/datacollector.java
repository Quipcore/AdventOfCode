package datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class datacollector {

	/**
	 * Returns a integer array of lines from file one disk.
	 * @param URL
	 * @return
	 * @throws IOException
	 */
	public static int[] getIntArray(String URL) throws IOException {
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

	/**
	 * Returns a string array of lines from file on disk.
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String[] getStringArray(String url) throws IOException {

		List<String> inputList = getList(url);
		String[] inputdata = inputList.toArray(new String[inputList.size()]);

		return inputdata;
	}

	/**
	 * Returns a list of lines from file on disk.
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<String> getList(String url) throws IOException {
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
	
	/**
	 * Returns the first line of a file on disk.
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getFirstLine(String url) throws IOException {
		File file = new File(url);
		FileReader fr = new FileReader(file);
		try (BufferedReader br = new BufferedReader(fr)) {
			return br.readLine();
		}
	}
}
