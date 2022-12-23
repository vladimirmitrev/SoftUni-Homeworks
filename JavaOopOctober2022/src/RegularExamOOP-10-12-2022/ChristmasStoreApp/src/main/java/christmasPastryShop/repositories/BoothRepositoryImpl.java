package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Map<Integer, Booth> booths;

    public BoothRepositoryImpl() {
        this.booths = new LinkedHashMap<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return booths.get(number);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(booths.values());
    }

    @Override
    public void add(Booth booth) {
        this.booths.put(booth.getBoothNumber(), booth);
    }
}
