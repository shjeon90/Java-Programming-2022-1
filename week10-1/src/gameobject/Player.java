package gameobject;

import constants.Constants;
import item.Item;

import java.awt.*;

public class Player extends Unit {
    private Item[] inventory;
    private int numItem;

    public Player() {
        this.inventory = new Item[Constants.INVENTORY_SIZE];
        this.numItem = 0;
    }

    @Override
    public void draw(Graphics g) {
//        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.draw(this.getObject());
    }

    public void addItem(Item item) {
        if (this.numItem >= Constants.INVENTORY_SIZE) return;

        for (int i = 0;i < this.inventory.length;++i) {
            if (this.inventory[i] == null) {
                this.inventory[i] = item;
                this.numItem++;
                break;
            }
        }
    }

    public Item[] getInventory() {
        return inventory;
    }
}
