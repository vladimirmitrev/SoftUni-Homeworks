package filesAndStreamsExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("src/filesAndStreamsExercise/resources/output.txt")) {

            Path inputFile = Paths.get("src/filesAndStreamsExercise/resources/inputLineNumbers.txt");
            List<String> lines = Files.readAllLines(inputFile);
            for (int i = 0; i < lines.size(); i++) {
                pw.println(i + 1 + ". " + lines.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
