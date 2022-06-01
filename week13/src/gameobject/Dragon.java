package gameobject;

import constants.Constants;
import engine.Painter;
import item.DragonClaw;
import item.HealingPotion;
import item.Item;
import item.Sword;

import java.awt.*;
import java.util.Random;

public class Dragon extends Unit implements Drawable, Fightable, Runnable, Movable {
    private Item item;

    public Dragon() {
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.3) {
            this.item = new DragonClaw(Constants.ITEM_NAME_DRAGON_CLAW, Constants.ITEM_PRICE_DRAGON_CLAW);
        } else if (r < 0.8) {
            this.item = new HealingPotion(Constants.ITEM_NAME_HEALING_POTION, Constants.ITEM_PRICE_HEALING_POTION);
        } else {
            this.item = new Sword(Constants.ITEM_NAME_SWORD, Constants.ITEM_PRICE_SWORD);
        }

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

    @Override
    public void fight(Fightable target) {
        Random random = new Random();
//
//        boolean isCritical = random.nextBoolean();
        boolean isCritical = false;
        int damage = Math.max(this.getAtt() * (isCritical ? 2 : 1) - ((Unit)target).getDef(), 0);

        System.out.println("hit the dragon with " + damage + " att");
        ((Unit)target).setHp(Math.max(((Unit)target).getHp() - damage,  0));
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!this.isDead()) {
            try {
                int n = random.nextInt(Constants.MOVE_DIRECTIONS.values().length);

                this.move(Constants.MOVE_DIRECTIONS.values()[n]);
                Painter.getInstance().updateCurrentField();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void move(Constants.MOVE_DIRECTIONS direction) {
        switch(direction) {
            case up:
                this.y -= Constants.MOVE_DELTA;
                break;
            case down:
                this.y += Constants.MOVE_DELTA;
                break;
            case left:
                this.x -= Constants.MOVE_DELTA;
                break;
            case right:
                this.x += Constants.MOVE_DELTA;
                break;
            default:
                break;
        }
    }
}
