package advent2021.day14;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import datacollector.datacollector;

public class Day14 {

    static Map<String, String> polymerMap;
    static Map<Character, Long> Pt2CharMap;

    static long globalCounter;

    public static void main(String[] args) throws IOException {

        String puzzledata = "src/advent2021/day14/puzzledata";

        int result1 = part1(puzzledata, "NCOPHKVONVPNSKSHBNPF");
        System.out.println("Test 1: " + result1);

        long result2 = part2(puzzledata, "NCOPHKVONVPNSKSHBNPF");
        System.out.println("Test 2: " + result2);
    }

    public static int part1(String puzzledata, String template) throws IOException {

        polymerMap = new HashMap<>();

        datacollector.getStream(puzzledata).forEach(s -> {
            String[] temp = s.split(" ");
            polymerMap.put(temp[0], temp[2]);
        });


        String polyTemplate = template;
        StringBuilder newTemplate = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < polyTemplate.length() - 1; j++) {
                s.append(polyTemplate.charAt(j));
                s.append(polyTemplate.charAt(j + 1));

                newTemplate.append(polyTemplate.charAt(j));
                newTemplate.append(polymerMap.get(s.toString()));
                s = new StringBuilder();
            }
            newTemplate.append(polyTemplate.charAt(polyTemplate.length() - 1));
            polyTemplate = newTemplate.toString();
            newTemplate = new StringBuilder();
            System.out.println(polyTemplate.length() + " " + polyTemplate);
        }

        Map<Character, Integer> charcterAmount = new HashMap<>();
        for (Character c : polyTemplate.toCharArray()) {
            if (charcterAmount.containsKey(c)) {
                charcterAmount.put(c, charcterAmount.get(c) + 1);
            } else {
                charcterAmount.put(c, 1);
            }
        }
        int max = Collections.max(charcterAmount.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue();
        int min = Collections.min(charcterAmount.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue();


        return max - min;
    }

    public static long part2(String puzzledata, String template) throws IOException {

        polymerMap = new HashMap<>();
        Pt2CharMap = new HashMap<>();
        globalCounter = template.length();

        datacollector.getStream(puzzledata).forEach(s -> {
            String[] temp = s.split(" ");
            polymerMap.put(temp[0], temp[2]);
        });


        String polyTemplate = template;
        for (int i = 0; i < polyTemplate.length() - 1; i++) {
            char c = polyTemplate.charAt(i);
            if (Pt2CharMap.containsKey(c)) {
                Pt2CharMap.put(c, Pt2CharMap.get(c) + 1);
            } else {
                Pt2CharMap.put(c, 1L);
            }
            String searchPair = Character.toString(polyTemplate.charAt(i)) + Character.toString(polyTemplate.charAt(i + 1));
            search(searchPair, 1);
        }
        char c = polyTemplate.charAt(polyTemplate.length() - 1);
        if (Pt2CharMap.containsKey(c)) {
            Pt2CharMap.put(c, Pt2CharMap.get(c) + 1);
        } else {
            Pt2CharMap.put(c, 1L);
        }

        long max = 0;
        long min = Long.MAX_VALUE;
        for (Map.Entry<Character, Long> e : Pt2CharMap.entrySet().stream().toList()) {
            if (e.getValue() > max) {
                max = e.getValue();
            }
            if (e.getValue() < min) {
                min = e.getValue();
            }

        }


        return max - min;
    }


    private static void search(String polyPair, int round) {

        if(++globalCounter % 100000000 == 0){
            System.out.println(globalCounter);
        }
        try {
            char c = polymerMap.get(polyPair).charAt(0);
            if (Pt2CharMap.containsKey(c)) {
                Pt2CharMap.put(c, Pt2CharMap.get(c) + 1);

            } else {
                Pt2CharMap.put(c, 1L);
            }
            if (round < 40) {
                String firstPair = Character.toString(polyPair.charAt(0)) + Character.toString(c);
                String secondPair = Character.toString(c) + Character.toString(polyPair.charAt(1));
                search(firstPair, round + 1);
                search(secondPair, round + 1);
            }
        } catch (Exception e) {
            System.out.println(polyPair);
        }
    }

}
