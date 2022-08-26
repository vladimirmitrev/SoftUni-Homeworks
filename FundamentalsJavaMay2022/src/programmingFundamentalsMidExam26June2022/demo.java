package programmingFundamentalsMidExam26June2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while(!inputLine.equals("Finish")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Add":
                    int value = Integer.parseInt(commandLine[1]);
                    integerList.add(value);
                    break;
                case "Remove":
                    int valueRemove = Integer.parseInt(commandLine[1]);
                    for (int i = 0; i < integerList.size(); i++) {
                        int currentNum = integerList.get(i);
                        if (valueRemove == currentNum){
                            integerList.remove(i);
                            break;
                        }
                    }
                    break;
                case "Replace":
                    int valueReplace = Integer.parseInt(commandLine[1]);
                    int replacement = Integer.parseInt(commandLine[2]);
                    for (int i = 0; i < integerList.size(); i++) {
                        int currentValue = integerList.get(i);
                        if (valueReplace == currentValue) {
                            integerList.add(i, replacement);
                            integerList.remove(i + 1);
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    int valueCollapse = Integer.parseInt(commandLine[1]);
                    for (int i = 0; i < integerList.size(); i = 0) {
                        int currentCollapse = integerList.get(i);
                        if (valueCollapse > currentCollapse ) {
                            integerList.remove(i);
                        }
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }

        List<String> resultList = new ArrayList<>();
        for (int integer : integerList) {
            resultList.add(String.valueOf(integer));
        }
        System.out.println(String.join(" ", resultList));
    }
}
