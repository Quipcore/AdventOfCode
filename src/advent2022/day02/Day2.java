package advent2022.day02;

import datacollector.datacollector;

import java.io.IOException;

public class Day2 {

    public static void main(String[] args) throws IOException {
        String puzzledata = "src/advent2022/day02/puzzledata";
        
        int resultPart1 = part1(puzzledata);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(puzzledata);
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
