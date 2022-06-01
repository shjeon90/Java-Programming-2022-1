package gameobject;

import constants.Constants;
import item.Item;
import item.Sword;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static constants.Constants.MOVE_DIRECTIONS.*;

public class Player extends Unit implements Drawable, Fightable, Movable {
    private List<Item> inventory;
    private int budget;
    private Sword sword;

    public Player() {
        this.inventory = new ArrayList<>();
        this.budget = 0;
        this.sword = null;
    }



    @Override
    public void fight(Fightable target) {
        Random random = new Random();
//
        boolean isCritical = random.nextBoolean();
        int damage = Math.max(this.getAtt() * (isCritical ? 2 : 1) - ((Unit)target).getDef(), 0);

        System.out.println("got " + damage + " damages");
        ((Unit)target).setHp(Math.max(((Unit)target).getHp() - damage,  0));
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    @Override
    public void draw(Graphics g) {
//        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.draw(this.getObject());
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
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
