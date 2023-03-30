package advent2021.day3;

import java.io.IOException;

import utils.DataCollector;

public class Day3 {

    public static void main(String[] args) throws IOException {
        String[] inputdata = DataCollector.getStringArray("src/advent2021/day3/inputdata");
        int result = run1(inputdata);
        System.out.println(result);
    }

    public static int run1(String[] inputdata) {
        int zeros = 0;
        int ones = 0;

        int gamma = 0;
        int epsilon = 0;

        for (int i = 0; i < inputdata[0].length(); i++) {
            for (String strNum : inputdata) {

                if (strNum.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            if (zeros < ones) {
                gamma = gamma * 2 + 1;
                epsilon = epsilon * 2;
            } else {
                gamma = gamma * 2;
                epsilon = epsilon * 2 + 1;
            }

            zeros = 0;
            ones = 0;
        }

        return gamma * epsilon;
    }

    public static String run2(String[] inputdata) {
        return null;
    }
}
