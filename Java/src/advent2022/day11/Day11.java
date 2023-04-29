package advent2022.day11;

import utils.DataCollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day11 {

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "java/src/" + Day11.class.getPackageName().replace(".", "/") + "/puzzledata";

        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {

        List<Monkey> monkeys = parseMonkeys(DataCollector.getList(puzzledata), true);
        final int rounds = 20;
        for(int i = 0; i < rounds; i++){
            for(Monkey monkey : monkeys){
                for(Item item : monkey.inspectItems()){
                    monkeys.get(item.nextMonkey).addItem(item);
                }
            }

            for(Monkey monkey : monkeys){
                System.out.println(monkey);
            }
            System.out.println();
        }

        for(Monkey monkey : monkeys){
            System.out.printf("Monkey %d inspected %d items\n",monkey.getMonkeyNum(), monkey.getInspectedItems());

        }

        monkeys.sort(Monkey::compareTo);
        return monkeys.get(0).getInspectedItems() * monkeys.get(1).getInspectedItems();
    }



    public static int part2(String puzzledata) throws IOException {
        List<Monkey> monkeys = parseMonkeys(DataCollector.getList(puzzledata), false);
        final int rounds = 10000;
        for(int i = 0; i < rounds; i++){
            for(Monkey monkey : monkeys){
                for(Item item : monkey.inspectItems()){
                    monkeys.get(item.nextMonkey).addItem(item);
                }
            }
        }

        for(Monkey monkey : monkeys){
            System.out.printf("Monkey %d inspected %d items\n",monkey.getMonkeyNum(), monkey.getInspectedItems());

        }

        monkeys.sort(Monkey::compareTo);
        return monkeys.get(0).getInspectedItems() * monkeys.get(1).getInspectedItems();
    }

    public static List<Monkey> parseMonkeys(List<String> data, boolean setDivByThree){
        List<Monkey> monkeys = new LinkedList<>();
        for (int i = 0; i < data.size(); i += 7) {
            String a = String.valueOf(data.get(i).split(" ")[1].charAt(0));
            int monkeyNum = Integer.parseInt(a); // == i

            String[] split = data.get(i + 1).trim().split(" ");
            List<Integer> heldItems = new ArrayList<>();
            for (int j = 2; j < split.length; j++) {
                heldItems.add(Integer.parseInt(split[j].substring(0, 2)));
            }

            String operation = data.get(i + 2).trim().substring(17); //Operation: new = old * 19, old starts at pos 18
            int divisionConst = Integer.parseInt(data.get(i + 3).trim().split(" ")[3]);
            int trueMonkey = Integer.parseInt(data.get(i + 4).trim().split(" ")[5]);
            int falseMonkey = Integer.parseInt(data.get(i + 5).trim().split(" ")[5]);

            monkeys.add(new Monkey(i/7, heldItems, operation, divisionConst, trueMonkey, falseMonkey, setDivByThree));
        }
        return monkeys;
    }
}
