package filesAndStreamsLab;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) {

        String path = "input.txt";

        try {

//            File myFile = new File("sort-lines.txt");
//            if(!myFile.exists()) {
//                myFile.createNewFile();
//            } else {
//                myFile.delete();
//            }

            List<String> sortedLines = Files.readAllLines(Paths.get(path))
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            Path outputPath = Path.of("sort-lines.txt");

            Files.createFile(outputPath);

            Files.write(outputPath, sortedLines, StandardOpenOption.WRITE);

        } catch (IOException ignored) {

        }
    }
}
