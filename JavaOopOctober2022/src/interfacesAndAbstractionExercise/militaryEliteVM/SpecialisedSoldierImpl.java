package interfacesAndAbstractionExercise.militaryEliteVM;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return corps.getCorps();
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
