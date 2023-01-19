package examOthers;

import java.util.*;
import java.util.stream.Collectors;

public class P01MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vegetables = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(calories::push);
        List<Integer> readySalad = new ArrayList<>();

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int valueOfSalad=calories.pop();
            readySalad.add(valueOfSalad);
            while (!vegetables.isEmpty()&&valueOfSalad>0){
                switch (vegetables.poll()){
                    case "tomato":  valueOfSalad-=80 ; break;
                    case "carrot":  valueOfSalad-=136; break;
                    case "lettuce": valueOfSalad-=109; break;
                    case "potato":  valueOfSalad-=215; break;
                }
            }
        }
        System.out.println(readySalad.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        if(!vegetables.isEmpty()){
            System.out.println(vegetables.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        if(!calories.isEmpty()){
            System.out.println(calories.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
