package filesAndStreamsExercise;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("src/filesAndStreamsExercise/resources/Exercises Resources");

        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int totalSize = 0;

        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();

            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    files.offer(nestedFile);
                } else {
                    totalSize += nestedFile.length();
                }
            }
        }
        System.out.println("Folder size: " + totalSize);
    }
}
