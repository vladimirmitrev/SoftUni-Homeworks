package listsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);

            switch (command) {
                case "Contains":
                    int containsNumber = Integer.parseInt(commandLine.get(1));
                    if (numberList.contains(containsNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String secondCommand = commandLine.get(1);
                    if (secondCommand.equals("even")) {
                        List<Integer> evenNumbersList = getEvenNumber(numberList);
                        System.out.println(evenNumbersList.toString().replaceAll("[\\[\\],]", ""));
                    } else if (secondCommand.equals("odd")) {
                        List<Integer> oddNumbersList = getOddNumber(numberList);
                        System.out.println(oddNumbersList.toString().replaceAll("[\\[\\],]", ""));
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int num : numberList) {
                        sum += num;
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    String condition = commandLine.get(1);
                    int number = Integer.parseInt(commandLine.get(2));

                    List <Integer> conditionalNumList = getConditionNumbers(numberList, condition, number);
                    System.out.println(conditionalNumList.toString().replaceAll("[\\[\\],]", ""));
                    break;
            }

            input = scanner.nextLine();
        }

    }
    public static List<Integer> getEvenNumber(List<Integer> initList) {
        List<Integer> evenNumbersList = new ArrayList<>();
        for (int currentNum : initList) {
            if (currentNum % 2 == 0) {
                evenNumbersList.add(currentNum);
            }
        }
        return evenNumbersList;
    }

    public static List<Integer> getOddNumber (List<Integer> initList) {
        List<Integer> oddNumberList = new ArrayList<>();
        for (int i = 0; i < initList.size(); i++) {
            int currentNum = initList.get(i);

            if(currentNum % 2 != 0) {
                oddNumberList.add(currentNum);
            }
        }
        return oddNumberList;
    }

    public static List<Integer> getConditionNumbers (List<Integer> initList, String condition, int number) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < initList.size(); i++) {
            int currentNum = initList.get(i);

            if(condition.equals("<")) {
                if (currentNum < number) {
                    resultList.add(currentNum);
                }
            } else if (condition.equals(">")) {
                if (currentNum > number) {
                resultList.add(currentNum);
            }
            } else if (condition.equals("<=")) {
                if (currentNum <= number) {
                    resultList.add(currentNum);
                }
            } else if (condition.equals(">=")) {
                if (currentNum >= number) {
                    resultList.add(currentNum);
                }
            }
        }
        return resultList;
    }

}
