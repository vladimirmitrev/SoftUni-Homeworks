package filesAndStreamsLab;

import java.io.*;

public class P09Cube {

    public static class Cube implements Serializable {
        String color;
        double height;
        double length;
        double depth;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube iceCube = new Cube();

        iceCube.color = "green";
        iceCube.height = 12.4;
        iceCube.length = 15.3;
        iceCube.depth = 3;

        FileOutputStream fileOutputStream = new FileOutputStream("ice-cube.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(iceCube);

        FileInputStream inputStream = new FileInputStream("ice-cube.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Cube cube = (Cube)objectInputStream.readObject();

        System.out.println(cube);


    }
}
