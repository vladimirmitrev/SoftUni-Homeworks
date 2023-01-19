package filesAndStreamsExercise;

import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) {
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 250;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/filesAndStreamsExercise/resources/course.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/filesAndStreamsExercise/resources/course.ser"))) {
            oos.writeObject(course);

            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.numberOfStudents);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
