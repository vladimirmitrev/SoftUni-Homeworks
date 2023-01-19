package definingClassesExercise.P07Google;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;

    }
    public String format(){
        return String.format("%s %s",childName,childBirthday);
    }
}
