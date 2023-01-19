package filesAndStreamsLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {

        String path = "input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("extract-integers.txt");

            PrintWriter writer = new PrintWriter(outputStream);

            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.next());
                } else {
                    scanner.next();
                }
            }
            writer.close();

        } catch (IOException ignored) {

        }

    }
}
