package filesAndStreamsExercise;

import java.io.*;

public class P01SumLines {
    public static void main(String[] args) {

        try(BufferedReader bf = new BufferedReader(new FileReader("src/filesAndStreamsExercise/resources/input.txt"))) {
            String line = bf.readLine();
            while(line != null) {
                long sum = 0;
                char[] charsFromLine = line.toCharArray();
                for (char singleChar : charsFromLine) {
                    sum += singleChar;
                }
                System.out.println(sum);

                line = bf.readLine();
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
