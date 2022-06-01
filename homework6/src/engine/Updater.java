package engine;

import constant.Constant;
import object.Computer;
import object.Player;
import state.GlobalState;

import javax.swing.*;
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

    public boolean movePlayer(int n) {
        Player player = GlobalState.GLOBAL_STATE.player;
        int newX = player.getX();
        int newY = player.getY();
        boolean flag = false;

        for (int i = 0;i < n;++i) {
            if (newY == 0 && ((0 <= newX) && (newX < Constant.NUM_TILE_W-1))) {
                newX++;
            } else if (newY == Constant.NUM_TILE_H-1 && ((0 < newX) && (newX <= Constant.NUM_TILE_W-1))) {
                newX--;
            } else if (newX == Constant.NUM_TILE_W-1 && ((0 <= newY) && (newY < Constant.NUM_TILE_H-1))) {
                newY++;
            } else if (newX == 0 && ((0 < newY) && (newY <= Constant.NUM_TILE_H-1))) {
                newY--;
            }
            if (newX == 0 && newY == 0) {
                int round = player.getRound() + 1;
                player.setRound(round);
            }

            if (player.getRound() == Constant.N_WIN_ROUND) {
                flag = true;
                break;
            }
        }

        player.setX(newX);
        player.setY(newY);

        if (flag) {
            JOptionPane.showConfirmDialog(null, "player win!");
            GlobalState.GLOBAL_STATE.reset();
        }

        Painter.getInstance().update();

        return flag;
    }

    public boolean moveComputer(int n) {
        Computer computer = GlobalState.GLOBAL_STATE.computer;
        int newX = computer.getX();
        int newY = computer.getY();
        boolean flag = false;

        for (int i = 0;i < n;++i) {
            if (newY == 0 && ((0 <= newX) && (newX < Constant.NUM_TILE_W-1))) {
                newX++;
            } else if (newY == Constant.NUM_TILE_H-1 && ((0 < newX) && (newX <= Constant.NUM_TILE_W-1))) {
                newX--;
            } else if (newX == Constant.NUM_TILE_W-1 && ((0 <= newY) && (newY < Constant.NUM_TILE_H-1))) {
                newY++;
            } else if (newX == 0 && ((0 < newY) && (newY <= Constant.NUM_TILE_H-1))) {
                newY--;
            }

            if (newX == 0 && newY == 0) {
                int round = computer.getRound() + 1;
                computer.setRound(round);
            }

            if (computer.getRound() == Constant.N_WIN_ROUND) {
                flag = true;
                break;
            }
        }

        computer.setX(newX);
        computer.setY(newY);

        if (flag) {
            JOptionPane.showConfirmDialog(null, "Computer win!");
            GlobalState.GLOBAL_STATE.reset();
        }
        Painter.getInstance().update();

        return flag;
    }


}
