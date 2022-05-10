package gameobject;

import constants.Constants;

import java.awt.*;
import java.util.Random;

abstract public class Unit {
    protected String name;
    protected int x;
    protected int y;
    protected int hp;
    protected int att;
    protected int def;

    public Unit() {

    }

    public Unit(String name, int x, int y, int hp, int att, int def) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.att = att;
        this.def = def;
    }

    public void init(String name, int x, int y, int hp, int att, int def) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.att = att;
        this.def = def;
    }

    public Rectangle getObject() {
        return new Rectangle(this.x, this.y, Constants.UNIT_WIDTH, Constants.UNIT_HEIGHT);
    }


//    public void draw(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.BLACK);
//        g2d.draw(this.getObject());
//    }
    abstract public void draw(Graphics g);

    public void fight(Unit target) {
        Random random = new Random();
//
        boolean isCritical = random.nextBoolean();
        int damage = Math.max(this.getAtt() * (isCritical ? 2 : 1) - target.getDef(), 0);

        if (target instanceof Dragon) {
            System.out.println("hit the dragon with " + damage + " att");
        } else {
            System.out.println("got " + damage + " damages");
        }
        target.setHp(Math.max(target.getHp() - damage,  0));
    }

    public boolean hit(Unit unit) {
        return this.getObject().intersects(unit.getObject());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
