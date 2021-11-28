package advent2020.day4;

import java.io.*;

public class part1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2020\\day4\\inputdata");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String inputSTR = "";

        while ((line = br.readLine()) != null) {
            inputSTR += line;
        }
        fr.close();

        System.out.println(inputSTR);

    }
}
