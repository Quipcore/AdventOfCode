package advent2022.day11;

import java.util.List;
import java.util.Queue;

public class Monkey {

    public Monkey(List<Integer> heldItems, String operation, int testConstant, int trueMonkey, int falseMonkey) {
        this.heldItems = heldItems;
        this.operation = operation;
        String[] split = operation.split(" ");
        if(!split[2].equalsIgnoreCase("old")){
            this.operationConstant = Integer.parseInt(split[2]);
        }else{
            this.operationConstant = 0;
            useOld = true;
        }

        this.testConstant = testConstant;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
    }

    private boolean useOld = false;
    private Queue<Integer> heldItems;
    private String operation;
    private final int operationConstant;
    private final int testConstant;
    private int trueMonkey;
    private int falseMonkey;


    private int calcOperation(int old){
        int constant = operationConstant;
        if(useOld){
            constant = old;
        }

        if(operation.split(" ")[1].equalsIgnoreCase("+")){
            return old + constant;
        }
        return old*constant;
    }

    public int getNextMonkey(int old){
        if(calcOperation(old) % testConstant == 0){
            return trueMonkey;
        }
        return falseMonkey;
    }







}
