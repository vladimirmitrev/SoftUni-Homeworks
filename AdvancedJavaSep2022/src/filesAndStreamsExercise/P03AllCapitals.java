package filesAndStreamsExercise;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {


        try(BufferedReader bf = new BufferedReader(new FileReader("src/filesAndStreamsExercise/resources/input.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("src/filesAndStreamsExercise/resources/output.txt"))) {
            bf.lines().forEach(line -> pw.println(line.toUpperCase()));

//            while(line != null) {
//                String words = line.toUpperCase();
//
//                pw.println(words);
//
//                line = bf.readLine();
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
