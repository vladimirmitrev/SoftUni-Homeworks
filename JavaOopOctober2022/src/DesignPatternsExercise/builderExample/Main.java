package DesignPatternsExercise.builderExample;

public class Main {
    public static void main(String[] args) {

        Person builder = Person.builder()
                .withLastName("Mitrev")
                .withFirstName("Komi")
                .withAddress("Sofia")
                .build();
    }
}
