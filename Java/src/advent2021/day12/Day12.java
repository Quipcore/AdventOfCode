package advent2021.day12;

import java.io.IOException;
import java.util.*;

import utils.DataCollector;

public class Day12 {

    static Map<String, Set<String>> nodes;
    static List<String> paths;


    public static void main(String[] args) throws IOException {
        String puzzledata = "advent2021/day12/puzzledata";

        int result1 = part1(puzzledata);
        System.out.println("Test 1: " + result1);

        int result2 = part2(puzzledata);
        System.out.println("Test 2: " + result2);
    }

    // --------------------------------------------------------------------------------

    public static int part1(String puzzledata) throws IOException {
        nodes = new HashMap<>();
        paths = new LinkedList<>();
        DataCollector.getStream(puzzledata).forEach(s -> {
            String[] strArr = s.split("-");
            addNodes(strArr[0], strArr[1]);
            addNodes(strArr[1], strArr[0]);
        });

        search("start", "start");
        return paths.size();
    }

    private static void addNodes(String key, String value) {
        if (nodes.containsKey(key)) {
            if (!value.equals("start")) {
                nodes.get(key).add(value);
            }
        } else {
            if (!key.equals("end") && !value.equals("start")) {
                nodes.put(key, new HashSet<>());
                nodes.get(key).add(value);
            }
        }
    }

    private static void search(String node, String path) {
        List<String> pathNodes = Arrays.asList(path.split("-"));

        for (String n : nodes.get(node)) {
            if (!pathNodes.contains(n) || !Character.isLowerCase(n.charAt(0))) {
                if (n.equals("end")) {
                    paths.add(path);
                } else {
                    search(n, path + "-" + n);
                }
            }
        }
    }


// --------------------------------------------------------------------------------

    public static int part2(String puzzledata) throws IOException {
        nodes = new HashMap<>();
        paths = new LinkedList<>();

        DataCollector.getStream(puzzledata).forEach(s -> {
            String[] strArr = s.split("-");
            addNodes(strArr[0], strArr[1]);
            addNodes(strArr[1], strArr[0]);
        });

        search2("start", "start");
        return paths.size();
    }


    private static void search2(String node, String path) {
        if (isValid(Arrays.asList(path.split("-")))) {
            for (String n : nodes.get(node)) {
                if (n.equals("end")) {
                    paths.add(path);
                } else {
                    search2(n, path + "-" + n);
                }
            }
        }
    }

    private static boolean isValid(List<String> pathNodes) {
        if (pathNodes.size() == 1) {
            return true;
        }

        Map<String, Integer> m = new HashMap<>();
        for (String s : pathNodes) {
            if (Character.isLowerCase(s.charAt(0))) {
                if (m.containsKey(s)) {
                    if (m.get(s) == 2) {
                        return false;
                    }
                    m.put(s, m.get(s) + 1);
                } else {
                    m.put(s, 1);
                }
            }
        }
        return (m.values().stream().filter(i -> i > 1).count() < 2);
    }


}
