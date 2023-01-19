package definingClassesExercise.P07Google;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parent> parentList;
    private List<Children> childrenList;
    private Car car;


    public Person(String name, List<Pokemon> pokemonList, List<Parent> parentList, List<Children> childrenList) {
        this.name = name;
        this.pokemonList = pokemonList;
        this.parentList = parentList;
        this.childrenList = childrenList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
    public List<Parent> getParentList() {
        return parentList;
    }
    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void printFormat() {
        System.out.println(name);
        System.out.println("Company:");
        if(company != null) {
            System.out.println(company.format());
        }
        System.out.println("Car:");
        if(car != null) {
            System.out.println(car.format());
        }
        System.out.println("Pokemon:");
        if(!pokemonList.isEmpty()) {
            pokemonList.forEach(e -> System.out.printf("%s%n", e.format()));
        }
        System.out.println("Parents:");
        if(!parentList.isEmpty()) {
            parentList.forEach(e -> System.out.printf("%s%n", e.format()));
        }
        System.out.println("Children:");
        if(!childrenList.isEmpty()) {
            childrenList.forEach(e -> System.out.printf("%s%n", e.format()));
        }
    }

}
