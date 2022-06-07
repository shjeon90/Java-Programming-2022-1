package engine;

import constants.Constants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputGetter extends KeyAdapter implements Manager {
    private Updater updater;

    public InputGetter() {
    }

    public void init(Updater updater) {
        this.updater = updater;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
//                this.updater.movePlayer(0, -Constants.MOVE_DELTA);
                this.updater.movePlayer(Constants.MOVE_DIRECTIONS.up);
                break;
            case KeyEvent.VK_DOWN:
//                this.updater.movePlayer(0, Constants.MOVE_DELTA);
                this.updater.movePlayer(Constants.MOVE_DIRECTIONS.down);
                break;
            case KeyEvent.VK_LEFT:
//                this.updater.movePlayer(-Constants.MOVE_DELTA, 0);
                this.updater.movePlayer(Constants.MOVE_DIRECTIONS.left);
                break;
            case KeyEvent.VK_RIGHT:
//                this.updater.movePlayer(Constants.MOVE_DELTA, 0);
                this.updater.movePlayer(Constants.MOVE_DIRECTIONS.right);
                break;
            case KeyEvent.VK_SPACE:
                this.updater.attack();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
