package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsInfo = scanner.nextLine().split(";");
        Robots[] robots = new Robots[robotsInfo.length];
        for (int i = 0; i < robotsInfo.length; i++) {
            String[] robotData = robotsInfo[i].split("-");
            Robots data = new Robots(robotData[0], Integer.parseInt(robotData[1]), 0);
            robots[i] = data;
        }
        String[] time = scanner.nextLine().split(":");
        int startTime = (Integer.parseInt(time[0]) * 3600) + (Integer.parseInt(time[1]) * 60) + Integer.parseInt(time[2]);

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String productsInfo;
        while (!"End".equals(productsInfo = scanner.nextLine())) {
            productsQueue.offer(productsInfo);
        }

        while (!productsQueue.isEmpty()) {

            startTime++;
            String product = productsQueue.poll();
            boolean productIsNotAccepted = true;

            for (Robots robot : robots) {
                if (robot.getWorkingTime() > 0) {
                    robot.setWorkingTime(robot.getWorkingTime() - 1);
                }
                if (robot.getWorkingTime() == 0 && productIsNotAccepted) {
                    robot.setWorkingTime(robot.getProcessTime());
                    System.out.println(robotInfo(startTime, robot.getName(), product));
                    productIsNotAccepted = false;
                }
            }
            if (productIsNotAccepted) {
                productsQueue.offer(product);
            }
        }
    }

    private static String robotInfo(int startTime, String name, String product) {
        return String.format("%s - %s [%02d:%02d:%02d]", name, product, (startTime / 3600) % 24
                , (startTime / 60) % 60, startTime % 60);
    }

    public static class Robots {
        String name;
        int processTime;
        int workingTime;

        public String getName() {
            return name;
        }

        public int getProcessTime() {
            return processTime;
        }

        public int getWorkingTime() {
            return workingTime;
        }

        public void setWorkingTime(int workingTime) {
            this.workingTime = workingTime;
        }

        public Robots(String name, int processTime, int workingTime) {
            this.name = name;
            this.processTime = processTime;
            this.workingTime = workingTime;
        }
    }
}
