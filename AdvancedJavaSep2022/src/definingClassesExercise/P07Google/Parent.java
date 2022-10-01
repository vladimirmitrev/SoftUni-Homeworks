package definingClassesExercise.P07Google;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String format(){
        return String.format("%s %s",parentName,parentBirthday);
    }
}
