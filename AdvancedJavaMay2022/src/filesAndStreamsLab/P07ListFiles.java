package filesAndStreamsLab;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class P07ListFiles {
    public static void main(String[] args) {

        File root = new File("c:\\Users\\User357\\Desktop\\SoftUni Docs" +
                "\\Java Advanced\\Advanced May 2022" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));

    }
}
