package advent2021.day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import datacollector.datacollector;

public class Day11 {
    private static class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        String puzzledata = "src/advent2021/day11/puzzledata";

        int result1 = part1(puzzledata);
        System.out.println("Test 1: " + result1);

        int result2 = part2(puzzledata);
        System.out.println("Test 2: " + result2);
    }

    // --------------------------------------------------------------------------------

    public static int part1(String puzzledata) throws IOException {
        String[] rows = datacollector.getStringArray(puzzledata);

        int[][] octopuses = new int[10][10];
        int counter = 0;
        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows[r].length(); c++) {
                octopuses[r][c] = Integer.valueOf(String.valueOf(rows[r].charAt(c)));
            }
        }
        for (int n = 1; n <= 100; n++) {
            List<Pair> zeroes = new ArrayList<>();

            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    octopuses[r][c]++;
                    if (octopuses[r][c] > 9) {
                        octopuses[r][c] = 0;
                        zeroes.add(new Pair(r, c));
                    }
                }
            }

            zeroes.stream().forEach(p -> increaseAdjacents(octopuses, p.row, p.col));

            counter = counter +
                    (int) Arrays.stream(octopuses)
                            .flatMapToInt(Arrays::stream)
                            .filter(v -> v == 0)
                            .count();

        }

        return counter;
    }

    private static void increaseAdjacent(int[][] octopuses, int r, int c) {
        if (r >= 0 && r <= 9 && c >= 0 && c <= 9 && octopuses[r][c] != 0) {
            octopuses[r][c]++;
            if (octopuses[r][c] > 9) {
                octopuses[r][c] = 0;
                increaseAdjacents(octopuses, r, c);
            }
        }
    }

    private static void increaseAdjacents(int[][] octopuses, int r, int c) {
        increaseAdjacent(octopuses, r - 1, c - 1);
        increaseAdjacent(octopuses, r - 1, c);
        increaseAdjacent(octopuses, r - 1, c + 1);
        increaseAdjacent(octopuses, r, c - 1);
        increaseAdjacent(octopuses, r, c + 1);
        increaseAdjacent(octopuses, r + 1, c - 1);
        increaseAdjacent(octopuses, r + 1, c);
        increaseAdjacent(octopuses, r + 1, c + 1);
    }

    // --------------------------------------------------------------------------------

    public static int part2(String puzzledata) throws IOException {
        String[] rows = datacollector.getStringArray(puzzledata);

        int[][] octopuses = new int[10][10];
        int counter = 0;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                octopuses[r][c] = Integer.valueOf(String.valueOf(rows[r].charAt(c)));
            }
        }
        boolean allZeroes = false;
        while (!allZeroes) {
            counter++;
            List<Pair> zeroes = new ArrayList<>();
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    octopuses[r][c]++;
                    if (octopuses[r][c] > 9) {
                        octopuses[r][c] = 0;
                        zeroes.add(new Pair(r, c));
                    }
                }
            }
            zeroes.stream().forEach(p -> increaseAdjacents(octopuses, p.row, p.col));
            allZeroes = Arrays.stream(octopuses)
                    .flatMapToInt(Arrays::stream)
                    .allMatch(v -> v == 0);

        }

        return counter;
    }


}
