package advent2022.day09;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import utils.DataCollector;

public class Day9 {

    enum Directions {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day9.class.getPackageName().replace(".", "/") + "/puzzledata";

        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        final int sX = 0;
        final int sY = 0;

        int headX = sX;
        int headY = sY;

        int tailX = sX;
        int tailY = sY;

        Set<String> uniqueTailPos = new HashSet<>();
        uniqueTailPos.add(tailX + ", " + tailY);
        List<String> instructions = DataCollector.getList(puzzledata);

        for (String ins : instructions) {
            String[] split = ins.split(" ");
            String direction = split[0];
            int magnitude = Integer.parseInt(split[1]);

            for (int i = 0; i < magnitude; i++) {
                Directions dir = null;
                if (direction.equalsIgnoreCase("U")) {
                    headY++;
                    dir = Directions.UP;
                } else if (direction.equalsIgnoreCase("D")) {
                    headY--;
                    dir = Directions.DOWN;
                } else if (direction.equalsIgnoreCase("L")) {
                    headX--;
                    dir = Directions.LEFT;
                } else if (direction.equalsIgnoreCase("R")) {
                    headX++;
                    dir = Directions.RIGHT;
                }

                int[] newTailPos = moveTowards(headX, headY, tailX, tailY, dir);
                tailX = newTailPos[0];
                tailY = newTailPos[1];
                uniqueTailPos.add(String.format("%d, %d", tailX, tailY));
            }
        }

        return uniqueTailPos.size();
    }

    public static int[] moveTowards(int headX, int headY, int tailX, int tailY, Directions direction) {
        if (Math.abs(headX - tailX) < 2 && Math.abs(headY - tailY) < 2) {
            return new int[]{tailX, tailY};
        }

        if (direction.equals(Directions.LEFT)) {
            tailX = headX + 1;
            if(tailY != headY){
                tailY = headY;
            }
        } else if (direction.equals(Directions.RIGHT)) {
            tailX = headX - 1;
            if(tailY != headY){
                tailY = headY;
            }
        }


        if (direction.equals(Directions.UP)) {
            tailY = headY - 1;
            if(tailX != headX){
                tailX = headX;
            }
        } else if (direction.equals(Directions.DOWN)) {
            tailY = headY + 1;
            if(tailX != headX){
                tailX = headX;
            }
        }


        return new int[]{tailX, tailY};
    }

    public static int part2(String puzzledata) throws IOException {
        final int sX = 0;
        final int sY = 0;

        int headX = sX;
        int headY = sY;

        int[] knotsX = new int[9];
        int[] knotsY = new int[9];

        List<String> uniqueTailPos = new LinkedList<>();
        uniqueTailPos.add(String.format("%d, %d", 0, 0));
        List<String> instructions = DataCollector.getList(puzzledata);

        for (String ins : instructions) {
            String[] split = ins.split(" ");
            String direction = split[0];
            int magnitude = Integer.parseInt(split[1]);

            for (int i = 0; i < magnitude; i++) {
                Directions dir = null;
                if (direction.equalsIgnoreCase("U")) {
                    headY++;
                    dir = Directions.UP;
                } else if (direction.equalsIgnoreCase("D")) {
                    headY--;
                    dir = Directions.DOWN;
                } else if (direction.equalsIgnoreCase("L")) {
                    headX--;
                    dir = Directions.LEFT;
                } else if (direction.equalsIgnoreCase("R")) {
                    headX++;
                    dir = Directions.RIGHT;
                }

                int[] newTailPos = moveTowards(headX, headY, knotsX[0], knotsY[0], dir);
                knotsX[0] = newTailPos[0];
                knotsY[0] = newTailPos[1];
                for(int j = 1; j < knotsX.length; j++){
                    newTailPos = moveTowards(knotsX[j-1], knotsY[j-1], knotsX[j], knotsY[j], dir);
                    knotsX[j] = newTailPos[0];
                    knotsY[j] = newTailPos[1];
                }
                String formatedString = String.format("%d, %d", knotsX[knotsX.length-1], knotsY[knotsY.length-1]);
                if(!uniqueTailPos.contains(formatedString)){
                    uniqueTailPos.add(formatedString);
                }
            }
        }

        for(String str : uniqueTailPos){
            System.out.println(str);
        }

        return uniqueTailPos.size();
    }

}
