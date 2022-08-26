package finalExamPrep01;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List> piecesMap = new LinkedHashMap<>();
        for (int pieces = 1; pieces <= countPieces ; pieces++) {
            String piecesInput = scanner.nextLine();
            String[] piecesPart = piecesInput.split("\\|");
            String pieceName = piecesPart[0];
            String composer = piecesPart[1];
            String tone = piecesPart[2];

            List<String> newPieces = new ArrayList<>();
            newPieces.add(composer);
            newPieces.add(tone);

            piecesMap.put(pieceName, newPieces);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {

            if(command.contains("Add")) {
                String piece = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String tone = command.split("\\|")[3];

                if(!piecesMap.containsKey(piece)) {
                    List<String> currentPiece = new ArrayList<>();
                    currentPiece.add(composer);
                    currentPiece.add(tone);
                    piecesMap.put(piece, currentPiece);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, tone);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }

            } else if(command.contains("Remove")) {
                String piece = command.split("\\|")[1];
                if(piecesMap.containsKey(piece)) {
                    piecesMap.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            } else if(command.contains("ChangeKey")) {
                String piece = command.split("\\|")[1];
                String newTone = command.split("\\|")[2];

                if(piecesMap.containsKey(piece)) {
                    List<String> newInfo = piecesMap.get(piece);
                    newInfo.remove(1);
                    newInfo.add(newTone);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newTone);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }
            command = scanner.nextLine();
        }
        piecesMap.entrySet().forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
