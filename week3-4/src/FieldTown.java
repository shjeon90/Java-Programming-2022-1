public class FieldTown {

    public FieldTown() {

    }

    public String getMenu() {
        String menu = "menu======================\n";
        menu += "1. Move to the east forest\n";
        menu += "2. Move to the west forest\n";
        menu += "3. Move to the south forest\n";
        menu += "4. Move to the north forest\n";
        menu += "5. Run\n";
        menu += "==========================\n";
        menu += "> ";
        return menu;
    }

    public boolean validateInput(int input) {
        return (1 <= input) && (input <= 5);
    }
}
