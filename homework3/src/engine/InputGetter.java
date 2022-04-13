package engine;

import state.GlobalState;

import java.util.Random;
import java.util.Scanner;

public class InputGetter {
    private GlobalState globalState;
    private Painter painter;
    private Scanner scanner;
    private Random random;

    public InputGetter() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void init(GlobalState globalState, Painter painter) {
        this.globalState = globalState;
        this.painter = painter;
    }

    public int getInt(boolean turnPlayer) {
        if (turnPlayer) {
            while (true) {
                int chosen = this.scanner.nextInt();
                if ((1 <= chosen) && (chosen <= 3)) {
                    return chosen;
                } else {
                    this.painter.paintMsg("wrong Input\n");
                }
            }
        } else {

            int chosen = this.random.nextInt(3) + 1;
            this.painter.paintMsg(chosen + "\n");
            return chosen;
        }
    }
}
