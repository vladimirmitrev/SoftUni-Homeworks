package _02_SalesDatabase.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "_02_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    @OneToMany(targetEntity = Sale.class, mappedBy = "product")
    private Set<Sale> sales;

    public Product() {}

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

        this.sales = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }


    public void addSales(Sale sale){
        this.sales.add(sale);
    }

    public void removeSales(Sale sale){
        this.sales.remove(sale);
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(sales);
    }
}
