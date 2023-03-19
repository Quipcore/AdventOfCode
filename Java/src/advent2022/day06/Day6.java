package advent2022.day06;

import java.io.IOException;

import datacollector.datacollector;

public class Day6 {

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day6.class.getPackageName().replace(".","/") + "/puzzledata";
        
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        String data = datacollector.getFirstLine(puzzledata);

        int markerLength = 4;
        return getAnswer(data, markerLength);
    }

    //--------------------------------------------------------------------------------

    public static int part2(String puzzledata) throws IOException{
        String data = datacollector.getFirstLine(puzzledata);

        int markerLength = 14;
        return getAnswer(data, markerLength);

    }

    //--------------------------------------------------------------------------------

    private static int getAnswer(String data, int markerLength){
        for(int i = 0; i < data.length()-markerLength; i++){
            char[] charData = new char[markerLength];
            for(int j = 0; j < charData.length; j++){
                charData[j] = data.charAt(i+j);
            }

            if(!containsRepetition(charData)){
                return i+markerLength;
            }
        }

        return -1;
    }
    //--------------------------------------------------------------------------------

    private static boolean containsRepetition(char[] data){
        for(int i = 0; i < data.length; i++){
            for(int j = i+1; j < data.length; j++){
                if(data[i] == data[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
