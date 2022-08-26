package listsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> listSeparated = Arrays.stream(input.split("\\|"))
                                .collect(Collectors.toList());
        Collections.reverse(listSeparated);

        System.out.println(listSeparated.toString().replace("[", "")
                                                   .replace("]", "")
                                                   .trim()
                                                   .replaceAll(",", "")
                                                   .replaceAll("\\s+", " "));
    }
}
