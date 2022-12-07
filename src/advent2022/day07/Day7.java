package advent2022.day07;

import java.io.IOException;
import java.util.List;

import datacollector.datacollector;

public class Day7 {
    private static int globalSum = 0;
    private static int globalMin = Integer.MAX_VALUE;
    private static int dirAmount = 0;

    public static void main(String[] args) throws Exception {
        final String PUZZLE_DATA = "src/" + Day7.class.getPackageName().replace(".","/") + "/puzzledata";
        
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
        //527140 too low
    }

    public static int part1(String puzzledata) throws Exception {
        List<String> ls = datacollector.getList(puzzledata);
        Dir currentDir = createStructure(ls);
        dirSize_1(currentDir);
        return globalSum;
    }

    //--------------------------------------------------------------

    private static Dir createStructure(List<String> ls) throws Exception {
        /*
        Valid commands
        $ cd name = change directory to name
        $ cd .. = change directory to parent
        $ ls = list all files and directories in current directory
        dir name = create directory name
        size name = create file in directory with name and size
         */
        ls.remove(0);
        Dir currentDir = new Dir(null, "/"); // Root
        for(String str : ls) {
            if (str.contains("$ cd")) {
                String[] split = str.split(" ");
                currentDir = split[2].equals("..") ? currentDir.getParent() : currentDir.changeDir(split[2]);
            }
            else if(str.contains("dir ")) {
                currentDir.addDir(new Dir(currentDir,str.split(" ")[1]));
                dirAmount++;
            }
            else if(str.equals("$ ls")) {
                currentDir.print();
            }
            else { //Add file to dir
                String[] split = str.split(" ");
                String fileName = split[1];
                int size = Integer.parseInt(split[0]);
                currentDir.addFile(new File(fileName, size));
            }
        }

        //Get root dir
        while(currentDir.getParent() != null){
            currentDir = currentDir.getParent();
        }
        return currentDir;
    }

    //--------------------------------------------------------------

    private static void dirSize_1(Dir currentDir){
        int sum = 0;
        for(Dir dir : currentDir.dirs){
            dirSize_1(dir);
            sum += dir.currentSize;
        }
        for(File files : currentDir.files){
            sum += files.size;
        }
        currentDir.currentSize = sum;
        if(sum <= 100_000){
            globalSum += sum;
        }
    }

    //--------------------------------------------------------------

    public static int part2(String puzzledata) throws Exception {
        List<String> ls = datacollector.getList(puzzledata);
        Dir currentDir = createStructure(ls);
        calcNodeValues(currentDir);
        int minSpace = currentDir.currentSize-40_000_000;

        findMin(currentDir,minSpace);
        return globalMin;
    }
    private static void calcNodeValues(Dir currentDir){
        int sum = 0;
        for(Dir dir : currentDir.dirs){
            calcNodeValues(dir);
            sum += dir.currentSize;
        }
        for(File files : currentDir.files){
            sum += files.size;
        }
        currentDir.currentSize = sum;
    }

    private static void findMin(Dir currentDir,int minSpace){
        for(Dir dir : currentDir.dirs){
            findMin(dir,minSpace);
        }
        if(currentDir.currentSize > minSpace){
            globalMin = Math.min(globalMin,currentDir.currentSize);
        }
    }

}
