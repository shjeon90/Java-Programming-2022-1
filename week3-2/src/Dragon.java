import java.util.Random;

public class Dragon {

    private int hp;
    private int att;
    private int def;

    public Dragon(int hp, int att, int def) {
        this.hp = hp;
        this.att = att;
        this.def = def;
    }

    public void fight(Player player) {
        Utils utils = new Utils();
        Random random = new Random();

        System.out.println("Dragon got raged!");
        boolean isCritical = random.nextBoolean();
        int damage = utils.max(this.getAtt() * (isCritical ? 2 : 1) - player.getDef(), 0);
        System.out.println("got " + damage + " damages");
        player.setHp(utils.max(player.getHp() - damage, 0));
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

    public String toString() {
        String str = "> Dragon\n";
        str += ("\thp: " + this.getHp() + "\n");
        str += ("\tatt: " + this.getAtt() + "\n");
        str += ("\tdef: " + this.getDef());
        return str;
    }
}
