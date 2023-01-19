package filesAndStreamsExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

        Path inputOne = Paths.get("src/filesAndStreamsExercise/resources/inputOne.txt");
        Path inputTwo = Paths.get("src/filesAndStreamsExercise/resources/inputTwo.txt");
        Path output = Paths.get("src/filesAndStreamsExercise/resources/mergeTwoFiles.txt");

        try
//           ( PrintWriter printWriter = new PrintWriter(new FileWriter("src/filesAndStreamsExercise/resources/mergeTwoFiles.txt", true)) )
         {

            List<String> firstText = Files.readAllLines(inputOne);
            List<String> secondText = Files.readAllLines(inputTwo);

            Files.write(output, firstText, StandardOpenOption.APPEND);
            Files.write(output, secondText, StandardOpenOption.APPEND);

//            for (String s : firstText) {
//                printWriter.println(s);
//            }
//            for (String s : secondText) {
//                printWriter.println(s);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
