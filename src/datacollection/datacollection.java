package datacollection;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class datacollection {
    public static void main(String[] args) throws IOException {
        String url = "https://adventofcode.com/2020/day/2/input";
        datacollection();
    }

    public static void datacollection() throws IOException {
        URL url = new URL("https://adventofcode.com/2020/day/2/input");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }
}
