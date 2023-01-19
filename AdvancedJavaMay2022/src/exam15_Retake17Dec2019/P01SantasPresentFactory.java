package exam15_Retake17Dec2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(materialBox::push);

        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(magicLevel::offer);

        TreeMap<String, Integer> toysMap = new TreeMap<>();

        int dollCounter = 0;
        int trainCounter = 0;
        int bearCounter = 0;
        int bicycleCounter = 0;

        while (!materialBox.isEmpty() && !magicLevel.isEmpty()) {
            int magicValue = magicLevel.peek();
            int materialValue = materialBox.peek();
            int sum = 0;
            if(materialValue != 0 && magicValue != 0) {
                sum = materialValue * magicValue;
                if(sum < 0) {
                    magicLevel.poll();
                    materialBox.pop();
                    materialBox.push(materialValue + magicValue);

                } else {
                    materialBox.pop();
                    magicLevel.poll();
                    switch (sum) {
                        case 150:
                            toysMap.put("Doll", toysMap.containsKey("Doll") ? toysMap.get("Doll") + 1 : 1);
                            dollCounter++;
                            break;
                        case 250:
                            toysMap.put("Wooden train",toysMap.containsKey("Wooden train")? toysMap.get("Wooden train") + 1 : 1);
                            trainCounter++;
                            break;
                        case 300:
                            toysMap.put("Teddy bear",toysMap.containsKey("Teddy bear")? toysMap.get("Teddy bear") + 1 : 1);
                            bearCounter++;
                            break;
                        case 400:
                            toysMap.put("Bicycle",toysMap.containsKey("Bicycle")? toysMap.get("Bicycle") + 1 : 1);
                            bicycleCounter++;
                            break;
                        default:
                            materialBox.push(materialValue + 15);
                }
            }
            } else {
                if(materialValue == 0) {
                    materialBox.pop();
                }
                if (magicValue == 0) {
                    magicLevel.poll();
                }
            }
        }

        if(dollCounter > 0  && trainCounter > 0 || bearCounter > 0 && bicycleCounter > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        String materialLeft = !materialBox.isEmpty() ? materialBox.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")) : null;
        if(materialLeft != null) {
            System.out.println("Materials left: " + materialLeft);
        }

        String magicLeft = !magicLevel.isEmpty() ? magicLevel.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")) : null;
        if(magicLeft != null) {
            System.out.println("Magic left: " + magicLeft);
        }

        toysMap.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));


    }
}
