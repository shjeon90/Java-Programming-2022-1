package object;

import constant.Constant;
import object.item.Item;
import util.Utils;

import java.util.Random;

public class Dragon extends Unit {

    private Item item;

    public Dragon(int hp, int att, int def) {
        super(hp, att, def);
        this.item = new Item("A", 10);
    }

    public Item getItem() {
        return item;
    }

    public void fight(Unit player) {
        Utils utils = new Utils();
        Random random = new Random();

        System.out.println("Object.Dragon got raged!");
        boolean isCritical = random.nextBoolean();
        int damage = utils.max(this.getAtt() * (isCritical ? 2 : 1) - player.getDef(), 0);
        System.out.println("got " + damage + " damages");
        player.setHp(utils.max(player.getHp() - damage, 0));
    }

    public static Dragon getNewDragon() {
        return new Dragon(Constant.DRAGON_HP, Constant.DRAGON_ATT, Constant.DRAGON_DEF);
    }

    public String toString() {
        String str = "> Dragon\n";
        str += ("\thp: " + this.getHp() + "\n");
        str += ("\tatt: " + this.getAtt() + "\n");
        str += ("\tdef: " + this.getDef());
        return str;
    }
}
