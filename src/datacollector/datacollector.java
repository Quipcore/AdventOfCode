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
		return getStream(url).mapToInt(s -> Integer.valueOf(s)).toArray();
	}
	
	//---------------------------------------------------------------------------------------------------

	public static String[] getStringArray(String url) throws IOException {
		return getStream(url).map(s -> String.valueOf(s)).toArray(size -> new String[size]);
	}

	//---------------------------------------------------------------------------------------------------
	
	public static List<String> getList(String url) throws IOException {
		return getStream(url).collect(() -> new LinkedList<>(), (list, element) -> list.add(element),
				(listA, listB) -> listA.addAll(listB));
	}

	//---------------------------------------------------------------------------------------------------
	
	@SuppressWarnings("resource")
	public static String getFirstLine(String url) throws IOException {
		return new BufferedReader(new FileReader(new File(url))).readLine();
	}

	//---------------------------------------------------------------------------------------------------
	
	public static Stream<String> getStream(String url) throws IOException {
		return Files.lines(Path.of(url));
	}

}
