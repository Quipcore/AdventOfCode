package advent2022.day07;

import java.util.ArrayList;
import java.util.List;

public class Dir {
    String name;
    private Dir parent;
    List<Dir> dirs = new ArrayList<>();
    List<File> files = new ArrayList<>();
    int currentSize;


    public Dir(Dir parent, String name) {
        this.parent = parent;
        this.name = name;
        currentSize = 0;
    }

    public void addDir(Dir dir) {
        dirs.add(dir);
    }

    public void addFile(File file) {
        files.add(file);
        currentSize += file.size;
    }

    public Dir getParent(boolean calc) {
        if (calc) {
            for (File file : files) {
                currentSize += file.size;
            }

            for (Dir dir : dirs) {
                currentSize += dir.currentSize;
            }
        }
        return parent;
}

    public Dir changeDir(String dirName) throws Exception {
        for (Dir dir : dirs) {
            if (dir.name.equals(dirName)) {
                return dir;
            }
        }
        throw new Exception("No such dir");
    }

    public void print() {
        for (Dir dir : dirs) {
            System.out.printf("%s (dir)\n", dir.name);
        }

        for (File file : files) {
            System.out.printf("%s (file, %d)", file.name, file.size);
        }
    }
}

