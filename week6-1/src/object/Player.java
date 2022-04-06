package object;

import constant.Constant;
import object.item.Item;
import util.Utils;

import java.util.Random;

public class Player extends Unit {
    private int budget;
    private Item[] inventory;

    public Player(int hp, int att, int def) {
        super(hp, att, def);
        this.inventory = new Item[Constant.MAX_INVENTORY];
        this.budget = 0;
    }

    public void fight(Dragon dragon) {
        Random random = new Random();
        Utils utils = new Utils();

        boolean isCritical = random.nextBoolean();
        int damage = utils.max(this.getAtt() * (isCritical ? 2 : 1) - dragon.getDef(), 0);
        System.out.println("hit the dragon with " + damage + " att");
        dragon.setHp(utils.max(dragon.getHp() - damage,  0));
    }

    public void increaseBudget(int money) {
        this.budget += money;
    }

    public int getBudget() {
        return budget;
    }

    public void keepItem(Item item) {
        for (int i = 0;i < Constant.MAX_INVENTORY;++i) {
            if (this.inventory[i] == null) {
                this.inventory[i] = item;
                return;
            }
        }
        System.out.println("full of inventory");
    }

    public Item[] getInventory() {
        return inventory;
    }

    public String toString() {
        String str = "> Player\n";
        str += ("\thp: " + this.getHp() + "\n");
        str += ("\tatt: " + this.getAtt() + "\n");
        str += ("\tdef: " + this.getDef() + "\n");
        str += ("\tbudget: " + this.budget);
        return str;
    }
}
