package datacollector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
		return Files.readAllLines(Path.of(url));
	}

	//---------------------------------------------------------------------------------------------------
	
	public static String getFirstLine(String url) throws IOException {
		return getStream(url).findFirst().orElse("");
	}

	public static List<String> getLines(String url, int startIndex, int endIndex) throws IOException {
		return getList(url).subList(startIndex, endIndex);
	}

	public static List<String> getLines(String url, int startIndex) throws IOException {
		List<String> wholeList = getList(url);
		return wholeList.subList(startIndex, wholeList.size());
	}

	//---------------------------------------------------------------------------------------------------
	
	public static Stream<String> getStream(String url) throws IOException {
		return Files.lines(Path.of(url));
	}

}
