package gameobject;

import constants.Constants;
import item.DragonClaw;
import item.Item;

import java.awt.*;

public class Dragon extends Unit {
    private Item item;

    public Dragon() {
        this.item = new DragonClaw(Constants.ITEM_NAME_DRAGON_CLAW, Constants.ITEM_PRICE_DRAGON_CLAW);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public void draw(Graphics g) {
//        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(this.getObject());
    }
}
