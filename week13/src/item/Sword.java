package item;

public class Sword extends Item {
    private int att;

    public Sword(String name, int price) {
        super(name, price);
        this.att = 10;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }
}
