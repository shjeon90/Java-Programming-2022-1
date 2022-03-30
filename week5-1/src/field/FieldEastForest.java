package field;

import constant.Constant;
import object.Dragon;

public class FieldEastForest {
    private Dragon dragon;

    public FieldEastForest() {
        this.dragon = new Dragon(Constant.DRAGON_HP, Constant.DRAGON_ATT, Constant.DRAGON_DEF);
    }

    public String getMenu() {
        String menu = "menu======================\n";
        menu += "1. Fight\n";
        menu += "2. Defense\n";
        menu += "3. Run\n";
        menu += "4. Back\n";
        menu += "==========================\n";
        menu += "> ";
        return menu;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public boolean validateInput(int input) {
        return (1 <= input) && (input <= 4);
    }
}
