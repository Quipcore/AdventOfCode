package advent2022.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Monkey implements Comparable<Monkey> {

    private final int monkeyNum;
    private final String operation;
    private final int operationConst;
    private final String operationSymbol;
    private final int divisionConst;
    private final int trueMonkey;
    private final int falseMonkey;

    private final boolean operandIsOld;
    private final boolean divByThree;

    private List<Integer> worryLevels;

    private int inspectedItems = 0;

    public Monkey(int monkeyNum, List<Integer> heldItems, String operation, int divisionConst, int trueMonkey, int falseMonkey, boolean setDivByThree) {
        this.monkeyNum = monkeyNum;
        this.worryLevels = heldItems;

        this.operation = operation;
        String[] opString = operation.split(" ");
        this.operationSymbol = opString[1];
        this.operandIsOld = opString[2].equals("old");
        if (!operandIsOld) {
            this.operationConst = Integer.parseInt(opString[2]);
        } else {
            this.operationConst = -1;
        }
        this.divisionConst = divisionConst;

        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.divByThree = setDivByThree;
    }

    public List<Item> inspectItems() {
        List<Item> thrownItems = new LinkedList<>();
        for (int worryItem : worryLevels) {
            int newWorryLevel;
            if (divByThree) {
                newWorryLevel = switch (operationSymbol) {
                    case "*" -> operandIsOld ? worryItem * worryItem : worryItem * operationConst;
                    case "+" -> operandIsOld ? worryItem + worryItem : worryItem + operationConst;
                    default -> throw new ArithmeticException("Symbol not * or +");
                };
                newWorryLevel /= 3;
            } else {
                newWorryLevel = switch (operationSymbol) {
                    case "*" -> operandIsOld ? worryItem * worryItem : worryItem * operationConst;
                    case "+" -> operandIsOld ? worryItem + worryItem : worryItem + operationConst;
                    default -> throw new ArithmeticException("Symbol not * or +");
                };

                newWorryLevel %= divisionConst;
            }

            if (newWorryLevel % divisionConst == 0) {
                thrownItems.add(new Item(trueMonkey, newWorryLevel));
            } else {
                thrownItems.add(new Item(falseMonkey, newWorryLevel));
            }

            inspectedItems++;
        }

        worryLevels = new LinkedList<>();
        return thrownItems;
    }

    public void addItem(Item item) {
        worryLevels.add(item.worryLevel);
    }

    public int getMonkeyNum() {
        return monkeyNum;
    }

    public int getInspectedItems() {
        return inspectedItems;
    }

    public String toString() {
        return "Monkey " + monkeyNum + ": " + worryLevels;
    }


    @Override
    public int compareTo(Monkey o) {
        if (o.getInspectedItems() == this.getInspectedItems()) {
            return 0;
        } else if (o.getInspectedItems() < this.getInspectedItems()) {
            return -1;
        } else if (o.getInspectedItems() > this.getInspectedItems()) {
            return 1;
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
