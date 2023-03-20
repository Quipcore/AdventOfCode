package advent2022.day05;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import utils.datacollector;


public class Day5 {

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day5.class.getPackageName().replace(".","/") + "/puzzledata";
        final String PUZZLE_STACK = "src/" + Day5.class.getPackageName().replace(".","/") + "/puzzlestack";

        String resultPart1 = part1(PUZZLE_DATA,PUZZLE_STACK);
        System.out.println("Part 1: " + resultPart1);

        String resultPart2 = part2(PUZZLE_DATA,PUZZLE_STACK);
        System.out.println("Part 2: " + resultPart2);
    }

    //--------------------------------------------------------------------------------

    public static String part1(String puzzledata,String puzzlestack) throws IOException {
        List<Stack<String>> stkList = initStacks(puzzlestack);
        List<String> instructionList = datacollector.getList(puzzledata);

        for (String s : instructionList) {

            String[] instruction = s.split(" ");
            int moveAmount = Integer.parseInt(instruction[1]);
            int moveFrom = Integer.parseInt(instruction[3])-1;
            int moveTo = Integer.parseInt(instruction[5])-1;

            for (int j = 1; j <= moveAmount; j++) {
                stkList.get(moveTo).push(stkList.get(moveFrom).pop());
            }

        }

        StringBuilder result = new StringBuilder();
        for(Stack<String> stk : stkList){
            result.append(stk.pop());
        }
        return result.toString();
    }

    //--------------------------------------------------------------------------------

    public static String part2(String puzzledata,String puzzlestack) throws IOException{
        List<Stack<String>> stkList = initStacks(puzzlestack);
        List<String> instructionList = datacollector.getList(puzzledata);

        for (String s : instructionList) {

            String[] instruction = s.split(" ");
            int moveAmount = Integer.parseInt(instruction[1]);
            int moveFrom = Integer.parseInt(instruction[3])-1;
            int moveTo = Integer.parseInt(instruction[5])-1;


            Stack<String> tempStack = new Stack<>();
            for (int j = 1; j <= moveAmount; j++) {
                tempStack.push(stkList.get(moveFrom).pop());
            }
            while(!tempStack.isEmpty()){
                stkList.get(moveTo).push(tempStack.pop());
            }

        }

        StringBuilder result = new StringBuilder();
        for(Stack<String> stk : stkList){
            result.append(stk.pop());
        }
        return result.toString();
    }

    //--------------------------------------------------------------------------------

    private static List<Stack<String>> initStacks(String puzzlestack) throws IOException {
        List<Stack<String>> stkList = new LinkedList<>();
        List<String> startStacks = datacollector.getList(puzzlestack);

        int stackCount =  startStacks.get(startStacks.size()-1).split(" {3}").length;

        for(int i = 0; i < stackCount; i++){
            stkList.add(new Stack<>());
        }

        for(int i = startStacks.size()-2; i >= 0; i--) {
            String[] stack = startStacks.get(i).split("]");

            for(int j = 0; j < stackCount; j++) {
                stack[j] = stack[j].replace("[","").replace("]","").strip();

                if(!stack[j].equals("")){
                    stkList.get(j).push(stack[j]);
                }
            }

        }

        return stkList;
    }



}
