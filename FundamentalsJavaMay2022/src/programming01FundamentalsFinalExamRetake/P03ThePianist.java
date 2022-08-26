package programming01FundamentalsFinalExamRetake;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> piecesMap = new LinkedHashMap<>();


        for (int i = 0; i < n ; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String tone = input[2];
            piecesMap.putIfAbsent(piece, new ArrayList<>());
            piecesMap.get(piece).add(0, composer);
            piecesMap.get(piece).add(1, tone);

        }
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Stop")) {
            String[] tokens = commandLine.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];
            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String tone = tokens[3];
                    if (piecesMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);

                    } else {
                        List<String> currentPiece = new ArrayList<>();
                        currentPiece.add(composer);
                        currentPiece.add(tone);
                        piecesMap.put(piece, currentPiece);

                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, tone);
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
                        List<String> newInfo = piecesMap.get(piece);
                        newInfo.remove(1);
                        newInfo.add(newTone);

                        System.out.printf("Changed the key of %s to %s!%n", piece, newTone);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        piecesMap.entrySet().forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n"
                , entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }

}
