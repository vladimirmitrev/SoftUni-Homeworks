package filesAndStreamsExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new FileReader("src/filesAndStreamsExercise/resources/input.txt"))) {
            String line = bf.readLine();
            long sum = 0;
            while(line != null) {
                char[] charsFromLine = line.toCharArray();
                for (char singleChar : charsFromLine) {
                    sum += singleChar;
                }

                line = bf.readLine();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
