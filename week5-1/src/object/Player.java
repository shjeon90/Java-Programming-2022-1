package object;

import util.Utils;

import java.util.Random;

public class Player {
    private int hp;
    private int att;
    private int def;

    public Player(int hp, int att, int def) {
        this.hp = hp;
        this.att = att;
        this.def = def;
    }

    public void fight(Dragon dragon) {
        Random random = new Random();
        Utils utils = new Utils();

        boolean isCritical = random.nextBoolean();
        int damage = utils.max(this.getAtt() * (isCritical ? 2 : 1) - dragon.getDef(), 0);
        System.out.println("hit the dragon with " + damage + " att");
        dragon.setHp(utils.max(dragon.getHp() - damage,  0));
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtt() {
        return this.att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int playerDef) {
        this.def = playerDef;
    }

    public String toString() {
        String str = "> Player\n";
        str += ("\thp: " + this.getHp() + "\n");
        str += ("\tatt: " + this.getAtt() + "\n");
        str += ("\tdef: " + this.getDef());
        return str;
    }
}
