package adventYYYY.dayDD;

import java.io.IOException;
import datacollector.datacollector;

public class DayDD {

    public static void main(String[] args) throws IOException {
        String puzzledata = "src/adventYYYY/dayDD/puzzledata";
        
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
