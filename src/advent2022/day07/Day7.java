package advent2022.day07;

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
        List<String> instructions = datacollector.getList(puzzledata);
        Dir currentDir = createStructure(instructions);
        sumOfNodesUnderLimit(currentDir,100_000);
        return globalSum;
    }

    public static int part2(String puzzledata) throws Exception {
        List<String> instructions = datacollector.getList(puzzledata);
        Dir currentDir = createStructure(instructions);
        int minSpace = currentDir.currentSize-40_000_000;
        getValueOfRemovalNode(currentDir,minSpace);
        return globalMin;
    }

    //--------------------------------------------------------------

    /**
     * Create node structure and returns root-node
     *     Valid commands
     *     $ cd name = change directory to name
     *     $ cd .. = change directory to parent
     *     $ ls = list all files and directories in current directory
     *     dir name = create directory name
     *     size name = create file in directory with name and size
     * @param instructions list of valid instructions
     * @return root node and its completed structure
     * @throws Exception
     */
    private static Dir createStructure(List<String> instructions) throws Exception {

        instructions.remove(0);
        Dir currentDir = new Dir(null, "/"); // Create root node

        for(String commands : instructions) {
            if (commands.contains("$ cd")) {
                String[] split = commands.split(" ");
                currentDir = split[2].equals("..") ? currentDir.getParent() : currentDir.changeDir(split[2]);
            }
            else if(commands.contains("dir ")) {
                currentDir.addDir(new Dir(currentDir,commands.split(" ")[1]));
                dirAmount++;
            }
            else if(commands.contains("$ ls")) {
                currentDir.print();
            }
            else { //Add file to dir
                String[] split = commands.split(" ");
                String fileName = split[1];
                int size = Integer.parseInt(split[0]);
                currentDir.addFile(new File(fileName, size));
            }
        }

        //Get root dir
        while(currentDir.getParent() != null){
            currentDir = currentDir.getParent();
        }

        calcNodeValues(currentDir);

        return currentDir;
    }

    //--------------------------------------------------------------

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

    //--------------------------------------------------------------

    private static void sumOfNodesUnderLimit(Dir currentDir,int limit){
        for(Dir dir : currentDir.dirs){
            sumOfNodesUnderLimit(dir,limit);
        }
        if(currentDir.currentSize <= limit){
            globalSum += currentDir.currentSize;
        }
    }

    //--------------------------------------------------------------

    private static void getValueOfRemovalNode(Dir currentDir, int minSpace){
        for(Dir dir : currentDir.dirs){
            getValueOfRemovalNode(dir,minSpace);
        }
        if(currentDir.currentSize > minSpace){
            globalMin = Math.min(globalMin,currentDir.currentSize);
        }
    }

}
