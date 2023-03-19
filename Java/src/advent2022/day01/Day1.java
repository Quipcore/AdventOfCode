package advent2022.day01;

import datacollector.datacollector;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) throws IOException {
        String puzzledata = "src/advent2022/day01/puzzledata";

        int resultPart1 = part1(puzzledata);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(puzzledata);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        List<String> calorieList = datacollector.getStream(puzzledata).collect(Collectors.toList());
        calorieList.add("");
        int max = 0;
        int sum = 0;

        for(String calorie: calorieList){
            if(calorie.equals("")){
                if(max < sum){
                    max = sum;
                }
                sum = 0;
            }else {
                sum += Integer.parseInt(calorie);
            }
        }

        return max;
    }

    public static int part2(String puzzledata) throws IOException{
        List<String> calorieList = datacollector.getStream(puzzledata).collect(Collectors.toList());
        calorieList.add("");
        List<Integer> totalCalories = new LinkedList<>();

        int sum = 0;
        for(String calorie: calorieList){
            if(calorie.equals("")){
                totalCalories.add(sum);
                sum = 0;
            }else {
                sum += Integer.parseInt(calorie);
            }
        }
        Collections.sort(totalCalories);
        Collections.reverse(totalCalories);
        return totalCalories.get(0) + totalCalories.get(1) +totalCalories.get(2);
    }
}
