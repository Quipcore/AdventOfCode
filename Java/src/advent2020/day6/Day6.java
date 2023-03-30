package advent2020.day6;

import utils.DataCollector;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        String puzzledata = "src/advent2020/day6/puzzledata";

        int result = part1(puzzledata);
        System.out.println("Test 1: " + result);

        result = part2(puzzledata);
        System.out.println("Test 2: " + result);
    }

    public static int part1(String puzzledata) throws IOException {
        List<String> dataList = DataCollector.getStream(puzzledata).toList();

        StringBuilder temp = new StringBuilder();
        int totalYes = 0;

        for (String ans : dataList) {
            if (!ans.equals("")) {
                for (char c : ans.toCharArray()) {
                    if (!temp.toString().contains(String.valueOf(c))) {
                        totalYes++;
                    }
                }
                temp.append(ans);
            } else {
                temp = new StringBuilder();
            }
        }

        return totalYes;
    }

    public static int part2(String puzzledata) throws IOException {
        List<String> dataList = DataCollector.getStream(puzzledata).collect(Collectors.toList());
        dataList.add(""); //Needed to access else statement for last string

        String temp = "";
        int totalYes = 0;
        int peopleInGroup = 0;
        for (String s : dataList) {
            if (!s.equals("")) {
                peopleInGroup++;
                temp += s;
            } else {

                System.out.println(temp);
                for (char c : ALPHABET.toCharArray()) {

                    int count = 0; // count = Times a letter appeared in string
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == c) {
                            count++;
                        }
                    }

                    if (count == peopleInGroup) {
                        totalYes++;
                    }
                }

                temp = "";
                peopleInGroup = 0;
            }
        }
        return totalYes;
    }

}
