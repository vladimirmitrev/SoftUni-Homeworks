package hiberspring.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Town town;

    @OneToMany(mappedBy = "branch")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "branch")
    private Set<Product> products;

    public Branch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
