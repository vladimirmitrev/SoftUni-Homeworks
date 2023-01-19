package filesAndStreamsLab;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {

        String path = "input.txt";

        try{
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("copy-bytes.txt");

            int read = inputStream.read();

            PrintWriter writer = new PrintWriter(outputStream);

            while (read != -1) {
                if(read == ' ')  {
                    writer.print(' ');
                } else if (read == 10) {
                    writer.println();
                } else {
                    writer.print(read);
                }
                read = inputStream.read();

            }
            writer.flush();

        } catch (IOException ignored) {

        }

    }
}
