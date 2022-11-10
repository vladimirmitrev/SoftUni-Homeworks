package multidimensionalArraysExercise;

import java.util.Scanner;

public class P08TheHeiganDance {

    private static final int[][] chamber = new int[15][15];
    private static int playerLife = 18500, playerRow = 7, playerCol = 7;
    private static double bossLife = 3000000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double playerDamage = Double.parseDouble(scanner.nextLine());
        int previousColHit = -1, previousRowHit = -1;
        String spell = "", previousSpell = "";

        while (playerLife > 0 && bossLife > 0) {
            bossLife -= playerDamage;
            if (bossLife <= 0) {
                if (chamber[playerRow][playerCol] > 0) playerLife -= 3500;
                continue;
            }
            String[] command = scanner.nextLine().split("\\s+");
            spell = command[0];
            int rowHit = Integer.parseInt(command[1]), colHit = Integer.parseInt(command[2]);
            if ("Cloud".equals(spell)) {
                if (chamber[playerRow][playerCol] > 0) {
                    playerLife -= 3500;
                    if (playerLife < 0) {
                        spell = previousSpell;
                        continue;
                    }
                }
                if ("Cloud".equals(previousSpell)) spellHitChamber(previousRowHit, previousColHit, -1);
                spellHitChamber(rowHit, colHit, 2);
                if (chamber[playerRow][playerCol] > 0) movePlayer();
                if (chamber[playerRow][playerCol] > 0) playerLife -= 3500;
                spellHitChamber(rowHit, colHit, -1);
            } else if ("Eruption".equals(spell)) {
                if (chamber[playerRow][playerCol] > 0) {
                    playerLife -= 3500;
                    if (playerLife < 0) {
                        spell = previousSpell;
                        continue;
                    }
                }
                if ("Cloud".equals(previousSpell)) spellHitChamber(previousRowHit, previousColHit, -1);
                spellHitChamber(rowHit, colHit, 1);
                if (chamber[playerRow][playerCol] > 0) movePlayer();
                if (chamber[playerRow][playerCol] > 0) playerLife -= 6000;
                spellHitChamber(rowHit, colHit, -1);
            }
            previousRowHit = rowHit;
            previousColHit = colHit;
            previousSpell = spell;
        }
        spell = "Cloud".equals(spell) ? "Plague Cloud" : spell;

        if (bossLife <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", bossLife);
        }
        if (playerLife <= 0) {
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %d%n", playerLife);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static void movePlayer() {
        if (playerRow - 1 >= 0 && chamber[playerRow - 1][playerCol] == 0) {
            playerRow--;
        } else if (playerCol + 1 < chamber[playerRow].length && chamber[playerRow][playerCol + 1] == 0) {
            playerCol++;
        } else if (playerRow + 1 < chamber.length && chamber[playerRow + 1][playerCol] == 0) {
            playerRow++;
        } else if (playerCol - 1 >= 0 && chamber[playerRow][playerCol - 1] == 0) {
            playerCol--;
        }
    }

    private static boolean isInChamber(int row, int col) {
        return row >= 0 && row < chamber.length && col >= 0 && col < chamber[row].length;
    }

    private static void spellHitChamber(int rowHit, int colHit, int duration) {
        for (int row = rowHit - 1; row <= rowHit + 1; row++) {
            for (int col = colHit - 1; col <= colHit + 1; col++) {
                if (isInChamber(row, col)) {
                    chamber[row][col] += duration;
                }
            }
        }
    }
}

