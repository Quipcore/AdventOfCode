package advent2021.day13;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import datacollector.datacollector;

public class Day13 {
    public static void main(String[] args) throws IOException {
        String dotdata = "advent2021/day12/puzzledata_dots";
        String folddata = "advent2021/day12/puzzledata_folds";

        int result = part1(dotdata, folddata);
        System.out.println("Test 1: " + result);

        //result = part2(puzzledata);
        System.out.println("Test 2: " + result);
    }

    public static int part1(String dotdata, String folddata) throws IOException {
        int yMax = Integer.valueOf(datacollector.getStream(folddata).filter(s -> s.contains("y=")).findFirst().get().split(" ")[2].split("=")[1]) * 2+1;
        int xMax = Integer.valueOf(datacollector.getStream(folddata).filter(s -> s.contains("x=")).findFirst().get().split(" ")[2].split("=")[1]) * 2+1;
        final boolean[][] map = new boolean[yMax][xMax];

        datacollector.getStream(dotdata).forEach(s -> {
            String[] temp = s.split(",");
            map[Integer.valueOf(temp[1])][Integer.valueOf(temp[0])] = true;
        });

        List<String> foldList = datacollector.getStream(folddata).map(s -> s.split(" ")[2]).collect(Collectors.toList());


        boolean[][] final_map = map;
        for (String fold : foldList) {
            String[] temp = fold.split("=");
            String direction = temp[0];
            int value = Integer.valueOf(temp[1]);

            boolean[][] map2;
            if(direction.equals("x")){
                map2 = new boolean[value][final_map[0].length];
            }else{
                map2 = new boolean[final_map.length][value];
            }

            for(int row = 0; row < map2.length;row++){
                for(int col = 0; col < map2[0].length;col++){
                    map2[col][row] = final_map[col][row];
                    if(direction.equals("x")){
                        map2[col][row] |= final_map[col][final_map[0].length-row-1];
                    }else{
                        map2[col][row] |= final_map[final_map.length-col-1][row];
                    }

                }
            }
            final_map = map2;
        }
        int counter = 0;
        for(int i = 0; i < final_map.length;i++){
            for(int j = 0; j <final_map[0].length;j++){
                if(final_map[i][j]){
                    counter++;
                }
            }
        }

        return counter;
    }

    public static int part2(String puzzledata) throws IOException {
        return 0;
    }
}
