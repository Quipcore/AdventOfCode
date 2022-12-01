package datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class datacollector {

	public static int[] getIntArray(String url) throws IOException {
		return getStream(url).mapToInt(Integer::valueOf).toArray();
	}
	
	//---------------------------------------------------------------------------------------------------

	public static String[] getStringArray(String url) throws IOException {
		return getStream(url).toArray(String[]::new);
	}

	//---------------------------------------------------------------------------------------------------
	
	public static List<String> getList(String url) throws IOException {
		return getStream(url).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
	}

	//---------------------------------------------------------------------------------------------------
	
	public static String getFirstLine(String url) throws IOException {
		return new BufferedReader(new FileReader(new File(url))).readLine();
	}

	//---------------------------------------------------------------------------------------------------
	
	public static Stream<String> getStream(String url) throws IOException {
		return Files.lines(Path.of(url));
	}

}
