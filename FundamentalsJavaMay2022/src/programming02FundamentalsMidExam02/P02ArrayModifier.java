package programming02FundamentalsMidExam02;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];


            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(commandLine[1]);
                    int index2 = Integer.parseInt(commandLine[2]);
                    int element1 = numbersArray[index1];
                    int element2 = numbersArray[index2];
                    numbersArray[index1] = element2;
                    numbersArray[index2] = element1;
                    break;
                case "multiply":
                    int multyIndex1 = Integer.parseInt(commandLine[1]);
                    int multyIndex2 = Integer.parseInt(commandLine[2]);
                    int multiElement1 = numbersArray[multyIndex1];
                    int multiElement2 = numbersArray[multyIndex2];
                    int product = multiElement1 * multiElement2;
                    numbersArray[multyIndex1] = product;
                    break;
                case "decrease":
                    for (int index = 0; index <= numbersArray.length - 1 ; index++) {
                       numbersArray[index] = numbersArray[index] - 1;
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }
        for (int i = 0; i <= numbersArray.length - 1; i++) {
            if (i != numbersArray.length - 1) {
                System.out.print(numbersArray[i] + ", ");
            } else {
                System.out.print(numbersArray[i]);
            }

        }
    }
}
