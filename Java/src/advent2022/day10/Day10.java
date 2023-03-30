package advent2022.day10;

import java.io.IOException;
import java.util.List;

import utils.DataCollector;

public class Day10 {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String PUZZLE_DATA = "src/" + Day10.class.getPackageName().replace(".", "/") + "/puzzledata";

        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {
        //addx -> 2 clock cycles
        //noop -> 1 clock cycles

        int xRegister = 1;
        int clockCycle = 0;
        int signalStrength = clockCycle * xRegister;
        List<Integer> cyclesToLookAt = List.of(20, 60, 100, 140, 180, 220);

        List<String> instructions = DataCollector.getList(puzzledata);
        for (String str : instructions) {
            String[] split = str.split(" ");
            clockCycle++;
            if (cyclesToLookAt.contains(clockCycle)) {
                signalStrength += xRegister * clockCycle;
            }

            if (split.length == 2) {
                clockCycle++;
                if (cyclesToLookAt.contains(clockCycle)) {
                    signalStrength += xRegister * clockCycle;
                }
                xRegister += Integer.parseInt(split[1]);
            }
        }
        return signalStrength;
    }

    public static int part2(String puzzledata) throws IOException, InterruptedException {

        int xRegister = 1;
        int clockCycle = 0;
        int pos = 0;
        List<String> instructions = DataCollector.getList(puzzledata);
        for (String str : instructions) {
            String[] split = str.split(" ");
            if(clockCycle % 40 == 0){
                pos = 0;
            }
            draw(xRegister, clockCycle,pos);
            pos++;
            clockCycle++;

            if (split.length == 2) {
                if(clockCycle % 40 == 0){
                    pos = 0;
                }
                draw(xRegister, clockCycle,pos);
                pos++;
                clockCycle++;

                xRegister += Integer.parseInt(split[1]);
            }

        }
        System.out.println();
        return 0;
    }

    private static void draw(int xRegister, int clockCycle, int pos) throws InterruptedException {
        if (clockCycle % 40 == 0) {
            System.out.println();
        }

        if (pos -1 == xRegister
                || pos == xRegister
                || pos + 1 == xRegister) {
            System.out.print("#");

        } else {
            System.out.print(".");
        }


    }

}
