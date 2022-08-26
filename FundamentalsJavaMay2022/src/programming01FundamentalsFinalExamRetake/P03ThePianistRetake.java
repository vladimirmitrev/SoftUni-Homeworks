package programming01FundamentalsFinalExamRetake;

import java.util.*;

public class P03ThePianistRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
           String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String tone = tokens[2];
            piecesMap.put(piece, new ArrayList<>());
            piecesMap.get(piece).add(0, composer);
            piecesMap.get(piece).add(1, tone);

        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];

            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String tone = tokens[3];

                    if(piecesMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        piecesMap.put(piece, new ArrayList<>());
                        piecesMap.get(piece).add(0, composer);
                        piecesMap.get(piece).add(1, tone);
                        System.out.printf("%s by %s in %s added to the collection!%n"
                                , piece, composer, tone);
                    }
                break;

                case "Remove":
                    if(piecesMap.containsKey(piece)) {
                        piecesMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

                case "ChangeKey":
                    String newTone = tokens[2];
                    if(piecesMap.containsKey(piece)) {
                        piecesMap.get(piece).set(1, newTone);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newTone);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
       piecesMap.forEach((key, value) ->
               System.out.printf("%s -> Composer: %s, Key: %s%n", key, value.get(0), value.get(1)));
    }
}
