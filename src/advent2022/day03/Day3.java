package advent2022.day03;

import datacollector.datacollector;

import java.io.IOException;
import java.util.List;

public class Day3 {

    private static final String PUZZLE_DATA = "src/" + Day3.class.getPackageName().replace(".","/") + "/puzzeldata";

    public static void main(String[] args) throws IOException {
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return datacollector.getStream(puzzledata).mapToInt(str ->{

            String firstPack = str.substring(0, str.length()/2);
            String secondPack = str.substring(str.length()/2);

            for(Character c : firstPack.toCharArray()){
                if(secondPack.contains(c.toString())){
                    return alphabet.indexOf(c)+1;
                }
            }
            return 0;
        }).reduce(0, Integer::sum);
    }

    public static int part2(String puzzledata) throws IOException{
        List<String> lineList = datacollector.getList(puzzledata);
        int result = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < lineList.size(); i += 3){
            String firstLine = lineList.get(i);
            String secondLine = lineList.get(i+1);
            String thirdLine = lineList.get(i+2);

            for(Character ch : alphabet.toCharArray()){
                if(firstLine.contains(ch.toString()) && secondLine.contains(ch.toString()) && thirdLine.contains(ch.toString())){
                    result += alphabet.indexOf(ch)+1;
                }
            }


        }
        return result;
    }
}
