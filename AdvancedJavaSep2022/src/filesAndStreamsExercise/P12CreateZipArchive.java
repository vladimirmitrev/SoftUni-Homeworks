package filesAndStreamsExercise;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) {

        String zipFile = "src/filesAndStreamsExercise/resources/files.zip";
        String[] srcFiles = { "src/filesAndStreamsExercise/resources/input.txt",
                "src/filesAndStreamsExercise/resources/inputOne.txt",
                "src/filesAndStreamsExercise/resources/inputTwo.txt"};

        try {
            byte[] buffer = new byte[1024];

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (int i = 0; i < srcFiles.length ; i++) {

                File srcFile = new File(srcFiles[i]);
                FileInputStream fis = new FileInputStream(srcFile);

                zos.putNextEntry(new ZipEntry(srcFile.getName()));

                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0 ,length);
                }
                zos.closeEntry();

                fis.close();
            }
            zos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }
    }
}