package advent2022.day07;

import java.io.IOException;
import java.util.List;

import datacollector.datacollector;

public class Day7 {

    private static int sum = 0;

    public static void main(String[] args) throws Exception {
        final String PUZZLE_DATA = "src/" + Day7.class.getPackageName().replace(".","/") + "/puzzledata";
        
        int resultPart1 = part1(PUZZLE_DATA);
        System.out.println("Part 1: " + resultPart1);

        int resultPart2 = part2(PUZZLE_DATA);
        System.out.println("Part 2: " + resultPart2);
    }

    public static int part1(String puzzledata) throws Exception {
        List<String> ls = datacollector.getList(puzzledata);
        Dir currentDir = createDir(ls);

        dirSize(currentDir);
        return sum;
    }

    private static Dir createDir(List<String> ls) throws Exception {
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
                currentDir = split[2].equals("..") ? currentDir.getParent(true) : currentDir.changeDir(split[2]);
            }
            else if(str.contains("dir ")) {
                currentDir.addDir(new Dir(currentDir,str.split(" ")[1]));
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
        while(currentDir.getParent(false) != null){
            currentDir = currentDir.getParent(false);
        }
        return currentDir;
    }

    private static void dirSize(Dir currentDir){
        for(Dir dir : currentDir.dirs){
            if(dir.currentSize <= 100000){
                sum += dir.currentSize;
            }
            dirSize(dir);
        }
    }


    public static int part2(String puzzledata) throws IOException{

        return 0;
    }
}
