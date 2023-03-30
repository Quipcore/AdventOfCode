package advent2022.day04;

import utils.DataCollector;

import java.io.IOException;

public class Day4 {

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day4.class.getPackageName().replace(".","/") + "/puzzledata";
        
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        return DataCollector.getStream(puzzledata).mapToInt(pairs ->{
            String[] ranges = pairs.split(",");

            int firstMin = Integer.parseInt(ranges[0].split("-")[0]);
            int firstMax = Integer.parseInt(ranges[0].split("-")[1]);

            int secondMin = Integer.parseInt(ranges[1].split("-")[0]);
            int secondMax = Integer.parseInt(ranges[1].split("-")[1]);
            //if one range fully contains the other, return 1

            if(firstMin <= secondMin && firstMax >= secondMax){
                return 1;
            }
            if(secondMin <= firstMin && secondMax >= firstMax){
                return 1;
            }

            return 0;
        }).sum();
    }

    public static int part2(String puzzledata) throws IOException{
        return DataCollector.getStream(puzzledata).mapToInt(pairs ->{
            String[] ranges = pairs.split(",");

            int firstMin = Integer.parseInt(ranges[0].split("-")[0]);
            int firstMax = Integer.parseInt(ranges[0].split("-")[1]);

            int secondMin = Integer.parseInt(ranges[1].split("-")[0]);
            int secondMax = Integer.parseInt(ranges[1].split("-")[1]);

            //if one range contains at least one value of the other, return 1
            if(firstMin <= secondMin && firstMax >= secondMin){
                return 1;
            }
            if(secondMin <= firstMin && secondMax >= firstMin){
                return 1;
            }

            return 0;
        }).sum();
    }
}
