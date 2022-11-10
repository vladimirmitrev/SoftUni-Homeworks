package interfacesAndAbstractionLab.borderControlWithAbstract;

public class Robot extends  IdentifiableImpl {

    private String model;


    protected Robot(String id, String model) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
