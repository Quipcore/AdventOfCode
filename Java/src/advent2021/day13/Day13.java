package advent2021.day13;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import utils.datacollector;

public class Day13 {
    public static void main(String[] args) throws IOException {
        String dotdata = "src/advent2021/day13/puzzledata_dots";
        String folddata = "src/advent2021/day13/puzzledata_folds";

        int result = part1(dotdata, folddata);
        System.out.println("Test 1: " + result);

        result = part2(dotdata, folddata);
        System.out.println("Test 2: " + result);
    }

    //---------------------------------------------------------------------------------------------------------

    public static int part1(String dotdata, String folddata) throws IOException {

        final Boolean[][] map = createMap(dotdata, folddata);
        List<String> foldList = datacollector.getStream(folddata).map(s -> s.split(" ")[2]).toList();

        String[] temp = foldList.get(0).split("=");
        String foldDirection = temp[0];
        int foldValue = Integer.parseInt(temp[1]);
        Boolean[][] final_map = foldMap(map, foldDirection, foldValue);

        int counter = (int) Arrays.stream(final_map).flatMap(Arrays::stream).filter(b -> b).count();

        return counter;
    }

    //---------------------------------------------------------------------------------------------------------

    public static int part2(String dotdata, String folddata) throws IOException {

        final Boolean[][] map = createMap(dotdata, folddata);
        List<String> foldList = datacollector.getStream(folddata)
                                             .map(s -> s.split(" ")[2]).toList();

        Boolean[][] final_map = map;
        for (String fold : foldList) {
            String[] temp = fold.split("=");
            String foldDirection = temp[0];
            int foldValue = Integer.parseInt(temp[1]);
            final_map = foldMap(final_map, foldDirection, foldValue);
        }

        String letterMap = "";
        for (Boolean[] booleans : final_map) {
            for (int x = 0; x < final_map[0].length; x++) {
                letterMap += booleans[x]
                        ? "#"
                        : ".";
            }
            letterMap += "\n";
        }
        System.out.println(letterMap);

        return 0;
    }

    //---------------------------------------------------------------------------------------------------------

    private static Boolean[][] createMap(String dotdata, String folddata) throws IOException {
        int yMax = Integer.parseInt(datacollector.getStream(folddata)
                .filter(s -> s.contains("y="))
                .findFirst()
                .orElse("")
                .split(" ")[2]
                .split("=")[1]) * 2 + 1;

        int xMax = Integer.parseInt(datacollector.getStream(folddata)
                .filter(s -> s.contains("x="))
                .findFirst()
                .orElse("")
                .split(" ")[2]
                .split("=")[1]) * 2 + 1;

        final Boolean[][] map = new Boolean[yMax][xMax];
        Arrays.stream(map).forEach(boolArr -> Arrays.fill(boolArr, false));

        datacollector.getStream(dotdata).forEach(s -> {
            String[] temp = s.split(",");
            map[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = true;
        });
        return map;
    }

    //---------------------------------------------------------------------------------------------------------

    private static Boolean[][] foldMap(Boolean[][] map, String foldDirection, int foldValue) {

        Boolean[][] foldedMap = foldDirection.equals("x")
                ? new Boolean[map.length][foldValue]
                : new Boolean[foldValue][map[0].length];

        for (int y = 0; y < foldedMap.length; y++) {
            for (int x = 0; x < foldedMap[0].length; x++) {
                foldedMap[y][x] = map[y][x];
                foldedMap[y][x] |= foldDirection.equals("x")
                        ? map[y][map[0].length - x - 1]
                        : map[map.length - y - 1][x];
            }
        }
        return foldedMap;
    }
}
