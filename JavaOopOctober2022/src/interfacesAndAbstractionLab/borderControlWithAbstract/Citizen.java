package interfacesAndAbstractionLab.borderControlWithAbstract;

public class Citizen extends IdentifiableImpl{

    private int age;
    private String name;

    protected Citizen(String id,  int age , String name) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
