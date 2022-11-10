package workingWithAbstractionExercise.greedyTimesDimo;

public class Item {
    private ItemType itemType;
    private String name;
    private long amount;

    public Item(ItemType itemType, String name, long amount) {
        this.itemType = itemType;
        this.name = name;
        this.amount = amount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
