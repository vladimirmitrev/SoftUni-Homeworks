package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Map<String ,Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new LinkedHashMap<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return delicacies.get(name);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(delicacies.values());
    }

    @Override
    public void add(Delicacy delicacy) {
        this.delicacies.put(delicacy.getName(), delicacy);
    }
}
