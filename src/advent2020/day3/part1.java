package advent2020.day3;

import java.io.*;

public class part1 {
    public static void main(String[] args) throws IOException {

        //Collect filedata
        String FilePath = "D:\\Eclipse Workspace\\AdventOfCode\\src\\advent2020\\day3\\inputdata";
        File file = new File(FilePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";


        int rows = 323;
        int columncopies = 7;

        //Set every element to "" and add line to every element x times
        String[] inputdata = new String[rows];
        int c = 0;
        while ((line = br.readLine()) != null) {
            inputdata[c] = "";
            for(int m = 0; m < ((rows*columncopies)/30 + 1); m++){
                inputdata[c] += line;
            }
            c++;
        }
        fr.close();

        //Creating and print map
        String[][] map = new String[rows][rows*columncopies];
        for(int row = 0; row < map.length; row++){
            for(int column = 0; column < map[0].length; column++){
                map[row][column] = String.valueOf(inputdata[row].charAt(column));
                System.out.print(map[row][column]);
             }
            System.out.println("");
        }

        //Checking for trees
        int j = 0;
        int trees = 0;
        for(int i = 1; i < map[0].length; i++) {
            if(i%3 == 0) {
                j++;
                if(map[j][i].equals("#")){
                    trees++;
                }
                System.out.println(j + ", " + i + ", " + map[j][i]);
            }
        }
        System.out.println("Tress amount: " + trees);
    }
}
