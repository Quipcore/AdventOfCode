package advent2022.day08;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import utils.datacollector;

public class Day8 {

    enum directions {
        UP,DOWN,LEFT,RIGHT
    }

    static List<String> coords = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        final String PUZZLE_DATA = "src/" + Day8.class.getPackageName().replace(".","/") + "/puzzledata";

        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws IOException {

        List<String> data = datacollector.getList(puzzledata);

        int[][] trees = new int[data.get(0).length()][data.size()];

        for(int x = 0; x < trees.length; x++){
            for(int y = 0; y < trees[x].length; y++){
                trees[x][y] = data.get(x).charAt(y) - '0';
            }
        }

        int visibleTrees = 0;
        for(int x = 0; x < trees.length; x++){
            for(int y = 0; y < trees[0].length; y++){
                if(isVisible(trees,x,y)){
                    visibleTrees++;
                }

            }
        }

        return visibleTrees;
    }

    private static boolean isVisible(int[][] trees, int x, int y) {
        if(x == 0 || x == trees.length || y == 0 || y == trees[0].length){
            return true;
        }
        int treeHeight = trees[x][y];
        boolean rowUp = true;
        boolean rowDown = true;
        boolean colLeft = true;
        boolean colRight = true;

        for(int i = 0; i < y; i++){
            if(treeHeight <= trees[x][i]){
                rowUp = false;
                break;
            }
        }

        for(int i = y+1; i < trees.length; i++){
            if(treeHeight <= trees[x][i]){
                rowDown = false;
                break;
            }
        }

        for(int i = 0; i < x; i++){
            if(treeHeight <= trees[i][y]){
                colLeft = false;
                break;
            }
        }

        for(int i = x+1; i < trees[0].length; i++){
            if(treeHeight <= trees[i][y]){
                colRight = false;
                break;
            }
        }
        return rowUp || rowDown || colLeft || colRight;
    }

    public static int part2(String puzzledata) throws IOException{

        List<String> data = datacollector.getList(puzzledata);

        int[][] trees = new int[data.get(0).length()][data.size()];

        for(int x = 0; x < trees.length; x++){
            for(int y = 0; y < trees[x].length; y++){
                trees[x][y] = data.get(x).charAt(y) - '0';
            }
        }

        int maxScenicScore = Integer.MIN_VALUE;
        for(int x = 1; x < trees.length-1; x++){
            for(int y = 1; y < trees[0].length-1; y++){
                maxScenicScore = Math.max(getScenicScore(trees,x,y),maxScenicScore);
            }
        }

        return maxScenicScore;
    }

    private static int getScenicScore(int[][] trees, int x, int y) {
        int treeHeight = trees[x][y];
        int score = 1;


//        score *= scoreY(y-1,0,x,treeHeight,trees,directions.UP);
//        score *= scoreY(y+1, trees.length,x,treeHeight,trees, directions.DOWN);

        int count = 0;
        for(int i = y-1; i >= 0; i--){
            count++;
            if(treeHeight <= trees[x][i]){
                break;
            }
        }
        score *= count;
        count = 0;

        for(int i = y+1; i < trees.length; i++){
            count++;
            if(treeHeight <= trees[x][i]){
                break;
            }
        }
        score *= count;
        count = 0;

        for(int i = x-1; i >= 0; i--){
            count++;
            if(treeHeight <= trees[i][y]){
                break;
            }
        }
        score *= count;
        count = 0;

        for(int i = x+1; i < trees[0].length; i++){
            count++;
            if(treeHeight <= trees[i][y]){
                break;
            }
        }
        score *= count;

        return score;
    }

    private static int scoreY(int toY, int fromY, int currentX, int treeHeight, int[][] trees, directions direction){
        int skip = 1;
        if(direction.equals(directions.UP)){

        }
        if(toY > fromY){
            skip = -1;
            fromY -= 1;
        }
        int count = 0;
        for(int i = toY; i >= fromY; i += skip){
            count++;
            if(treeHeight <= trees[currentX][i]) return count;
        }

        return -1;
    }
}
