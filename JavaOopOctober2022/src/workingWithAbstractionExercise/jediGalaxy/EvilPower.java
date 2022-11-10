package workingWithAbstractionExercise.jediGalaxy;

public class EvilPower {
    public void move(int evilRow, int evilCol, Field field) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (field.isInBounds(evilRow, evilCol)) {
                field.setValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }
}
