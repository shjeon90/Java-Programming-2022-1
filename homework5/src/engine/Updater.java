package engine;

import java.util.Random;

public class Updater {
    private static final Updater unique_updater = new Updater();

    public Updater() {

    }

    public static Updater getInstance() {
        return unique_updater;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void movePlayer(int n) {

    }

    public void moveComputer(int n) {

    }


}
