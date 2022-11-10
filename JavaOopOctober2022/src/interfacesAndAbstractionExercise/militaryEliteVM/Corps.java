package interfacesAndAbstractionExercise.militaryEliteVM;

public enum Corps {
    Airforces("Airforces"),
    Marines("Marines");

    private String corps;


    Corps(String corps) {
        this.corps = corps;
    }

    public String getCorps() {
        return corps;
    }
    public static boolean isValidCorps(String corps) {
        return corps.equals(Airforces.getCorps()) || corps.equals(Marines.getCorps());
    }
}
