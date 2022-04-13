package field;

import object.Computer;
import object.Player;

public class Field {
    private Player player;
    private Computer computer;
    private boolean isValid;

    public Field(boolean isValid) {
        this.player = null;
        this.computer = null;
        this.isValid = isValid;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        if (this.isValid) {
            return String.format("|%c%c|", this.player != null ? 'p' : ' ', this.computer != null ? 'c' : ' ');
        } else {
            return "    ";
        }
    }
}
