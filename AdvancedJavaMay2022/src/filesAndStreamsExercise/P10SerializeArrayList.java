package filesAndStreamsExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<>();
        double firstNum = 144;
        double secondNum = 11.11;
        double thirdNum = 55.55;
        numbers.add(firstNum);
        numbers.add(secondNum);
        numbers.add(thirdNum);

       try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/filesAndStreamsExercise/resources/list.ser"));
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/filesAndStreamsExercise/resources/list.ser"))) {
           oos.writeObject(numbers);

           List<Double> numbersList = (List) ois.readObject();

           for (Double aDouble : numbersList) {
               System.out.println(aDouble);
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
}
