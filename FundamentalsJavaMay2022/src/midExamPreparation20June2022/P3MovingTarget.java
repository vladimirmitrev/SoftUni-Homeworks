package midExamPreparation20June2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];
            int index = Integer.parseInt(commandLine[1]);
            int value = Integer.parseInt(commandLine[2]);

            switch (command) {
                case "Shoot":
                    if (isValidIndex(targetList, index)) {
                        int currentNum = targetList.get(index);
                        currentNum = currentNum - value;
                    if (currentNum <= 0) {
                        targetList.remove(index);
                    } else {
                        targetList.set(index, currentNum);
                    }
                }
                    break;
                case "Add":
                    if (isValidIndex(targetList, index)) {
                        targetList.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    boolean isValidRadius = targetList.size() - 1 >= index + value &&
                    targetList.size() - 1 >= index && index - value >= 0;
                    int radius = value * 2 + 1;
                    if(isValidRadius) {
                        for (int i = 0; i < radius; i++) {
                            targetList.remove(index - value);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            inputLine = scanner.nextLine();

        }
        List<String> resultList = new ArrayList<>();
        for (int target : targetList) {
            resultList.add(String.valueOf(target));
        }
        System.out.println(String.join("|", resultList));
    }
    public static boolean isValidIndex (List<Integer> list, int index) {
        return index <= list.size() - 1 && index >= 0;
    }
}
