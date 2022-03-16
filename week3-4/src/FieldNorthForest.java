public class FieldNorthForest {

    public FieldNorthForest() {

    }

    public String getMenu() {
        String menu = "menu======================\n";
        menu += "1. Fight\n";
        menu += "2. Defense\n";
        menu += "3. Run\n";
        menu += "==========================\n";
        menu += "> ";
        return menu;
    }

    public boolean validateInput(int input) {
        return (1 <= input) && (input <= 3);
    }
}
