package advent2022.day02;

import utils.datacollector;

import java.io.IOException;
import java.util.Map;

public class Day2 {

    static Map<String,Integer> playToPoint = Map.of(
            "X", 1, //Rock
            "Y", 2, //Paper
            "Z", 3 //Scissors
    );



    public static void main(String[] args) throws IOException {
        String puzzledata = "src/advent2022/day02/puzzledata";
        
        int resultPart1 = part1(puzzledata);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(puzzledata);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        return datacollector.getStream(puzzledata).mapToInt(line -> {

            String[] plays = line.split(" ");
            String elfPlay = plays[0];
            String response = plays[1];

            int matchResult = 0;
            Map<String,String> matchResultMap = Map.of(
                    "A", "Y",
                    "B", "Z",
                    "C", "X"
            );
            Map<String,String> elfPlayToRespooneMap = Map.of(
                    "A", "X",
                    "B", "Y",
                    "C", "Z"
            );
            if(elfPlayToRespooneMap.get(elfPlay).equals(response)){
                matchResult = 3;
            }else if(matchResultMap.get(elfPlay).equals(response)){
                matchResult = 6;
            }

            int points = playToPoint.get(response) + matchResult;
            System.out.println("Elf play: " + elfPlay + " Response: " + response + " Points: " + points);
            return points;
        }).reduce(0, Integer::sum);
    }

    public static int part2(String puzzledata) throws IOException{
        return datacollector.getStream(puzzledata).mapToInt(line -> {

            //X = Lose 0 , Y = Draw 3, Z = Win 6
            //A = Rock 1, B = Paper 2, C = Scissors 3
            Map<String,Integer> pointMap = Map.of(
                    "A X", 3,
                    "A Y", 4,
                    "A Z", 8,
                    "B X", 1,
                    "B Y", 5,
                    "B Z", 9,
                    "C X", 2,
                    "C Y", 6,
                    "C Z", 7
            );
            return pointMap.get(line);
        }).reduce(0, Integer::sum);
    }
}
