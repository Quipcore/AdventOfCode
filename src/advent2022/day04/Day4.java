package advent2022.day04;

import datacollector.datacollector;

import java.io.IOException;

public class Day4 {

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day4.class.getPackageName().replace(".","/") + "/puzzeldata";
        
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        datacollector.getStream(puzzledata);
        return 0;
    }

    public static int part2(String puzzledata) throws IOException{

        return 0;
    }
}
