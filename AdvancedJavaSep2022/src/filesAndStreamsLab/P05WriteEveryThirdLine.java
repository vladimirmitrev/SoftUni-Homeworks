package filesAndStreamsLab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter("write-every-third-line.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = bufferedReader.readLine();

            int counter = 0;

            while (line != null) {
                counter++;

                if (counter % 3 == 0) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException ignored) {

        }
    }
}
