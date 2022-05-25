package item;

public class HealingPotion extends Item {
    private int amount;

    public HealingPotion(String name, int price) {
        super(name, price);
        this.amount = 30;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
