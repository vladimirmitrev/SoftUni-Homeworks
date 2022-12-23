package christmasPastryShop.repositories;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Map<String ,Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new LinkedHashMap<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktails.get(name);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(cocktails.values());
    }

    @Override
    public void add(Cocktail cocktail) {
         this.cocktails.put(cocktail.getName(), cocktail);
    }
}
