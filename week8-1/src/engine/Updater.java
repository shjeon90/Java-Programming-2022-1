package engine;

import gameobject.Dragon;
import state.GlobalState;

import java.util.Random;

public class Updater {
    private Painter painter;

    public Updater() {

    }

    public void init(Painter painter) {
        this.painter = painter;
    }

    public void movePlayer(int dx, int dy) {
        if (GlobalState.globalState.player != null) {
            int curX = GlobalState.globalState.player.getX();
            int curY = GlobalState.globalState.player.getY();

            GlobalState.globalState.player.setX(curX + dx);
            GlobalState.globalState.player.setY(curY + dy);
        }

        this.painter.update();
    }

    public void attack() {
        if (GlobalState.globalState.player == null) return;
        Random random = new Random();

        for (int i = 0;i < GlobalState.globalState.dragons.length;++i) {
            Dragon dragon = GlobalState.globalState.dragons[i];
            if (dragon != null && dragon.hit(GlobalState.globalState.player)) {
                GlobalState.globalState.player.fight(dragon);

                if (dragon.getHp() <= 0) {
                    GlobalState.globalState.dragons[i] = null;
                } else if (random.nextBoolean()) {
                    dragon.fight(GlobalState.globalState.player);
                    if (GlobalState.globalState.player.getHp() <= 0) {
                        GlobalState.globalState.player = null;
                    }
                }

                break;
            }
        }

        this.painter.update();
    }
}
