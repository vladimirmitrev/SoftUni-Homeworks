package filesAndStreamsLab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {

        File root = new File("src/filesAndStreamsLab/resources/Files-and-Streams");

        Deque<File> folders = new ArrayDeque<>();
        folders.offer(root);
        int count = 0;
        while (!folders.isEmpty()) {

            File currentFile = folders.poll();

            File[] nestedFolders = currentFile.listFiles();

            if(nestedFolders != null) {
                for (File nestedFolder : nestedFolders) {
                    if(nestedFolder.isDirectory()) {
                        folders.offer(nestedFolder);
                    }
                }
            }

            count++;
            System.out.println(currentFile.getName());
        }
        System.out.println(count + " folders ");


//        File root = new File("c:\\Users\\User357\\Desktop\\SoftUni Docs" +
//                "\\Java Advanced\\Advanced May 2022" +
//                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\");
//
//
//        System.out.println(Files.walk((root.toPath()))
//                .map(Path::toFile)
//                .map(File::getName)
//                .collect(Collectors.joining(System.lineSeparator())));
//        System.out.println(root.length() + "folders");
//        //.filter(File::isDirectory)
////        Arrays.stream(root.listFiles())
////                .filter(File::isDirectory)
////                .forEach(d -> System.out.println(d.getName()));

    }
}
