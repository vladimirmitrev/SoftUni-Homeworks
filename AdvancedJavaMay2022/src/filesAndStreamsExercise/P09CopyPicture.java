package filesAndStreamsExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyPicture {
    public static void main(String[] args) {

        byte[] bytes = new byte[1024];

        try(FileInputStream fis = new FileInputStream("src/filesAndStreamsExercise/resources/orion-small.jpg");
            FileOutputStream fos = new FileOutputStream("src/filesAndStreamsExercise/resources/orion-smallCopy.jpg")) {

            while(fis.read(bytes) != -1) {
                fos.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
