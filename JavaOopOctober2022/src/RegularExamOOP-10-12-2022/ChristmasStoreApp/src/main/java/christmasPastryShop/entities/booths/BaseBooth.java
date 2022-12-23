package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;
    private double pricePerBooth;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        isReserved = false;
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReserved = true;
        this.pricePerBooth = (numberOfPeople * pricePerPerson);
    }

    @Override
    public double getBill() {
        double delicaciesSum = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        double cocktailsSum = cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();

        return delicaciesSum + cocktailsSum + this.pricePerBooth;
    }

    @Override
    public void clear() {
        isReserved = false;
        numberOfPeople = 0;
        cocktailOrders.clear();
        delicacyOrders.clear();
    }
}
