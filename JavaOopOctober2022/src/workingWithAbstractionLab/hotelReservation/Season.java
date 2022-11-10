package workingWithAbstractionLab.hotelReservation;

public enum Season {
    SPRING("Spring", 2),
    SUMMER("Summer", 4),
    AUTUMN("Autumn", 1),
    WINTER("Winter", 3);
    private String name;
    private int multiplier;

    Season(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public int getMultiplier() {
        return multiplier;
    }

}
