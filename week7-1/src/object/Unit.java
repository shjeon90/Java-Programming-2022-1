package object;

public class Unit {
    protected int hp;
    protected int att;
    protected int def;

    public Unit(int hp, int att, int def) {
        this.hp = hp;
        this.att = att;
        this.def = def;
    }

    public void fight(Unit unit) {

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
