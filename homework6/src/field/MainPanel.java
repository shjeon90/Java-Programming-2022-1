package field;

import constant.Constant;
import engine.Updater;
import object.RollingButton;
import object.Tile;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {
    private Tile[][] tiles;
    private RollingButton rollingButton;

    public MainPanel() {
        this.setPreferredSize(new Dimension(Constant.MAINPANEL_WIDTH, Constant.MAINPANEL_HEIGHT));
        this.setBackground(Color.GREEN);

        this.tiles = new Tile[Constant.NUM_TILE_H][Constant.NUM_TILE_W];
        this.rollingButton = new RollingButton(
                (Constant.MAINPANEL_WIDTH - Constant.BTN_WIDTH) / 2,
                (Constant.MAINPANEL_HEIGHT - Constant.BTN_HEIGHT) / 2
        );

        RollingListener listener = new RollingListener();
        this.addMouseListener(listener);
    }

    public void init() {
        for (int h = 0;h < Constant.NUM_TILE_H;++h) {
            for (int w = 0;w < Constant.NUM_TILE_W;++w) {
                if (h == 0) {
                    this.tiles[h][w] = new Tile(Constant.TILE_WIDTH * w, Constant.TILE_HEIGHT * h);
                } else if (h == Constant.NUM_TILE_H-1) {
                    this.tiles[h][w] = new Tile(Constant.TILE_WIDTH * w, Constant.TILE_HEIGHT * h);
                } else if (w == 0) {
                    this.tiles[h][w] = new Tile(Constant.TILE_WIDTH * w, Constant.TILE_HEIGHT * h);
                } else if (w == Constant.NUM_TILE_W - 1) {
                    this.tiles[h][w] = new Tile(Constant.TILE_WIDTH * w, Constant.TILE_HEIGHT * h);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int h = 0;h < Constant.NUM_TILE_H;++h) {
            for (int w = 0;w < Constant.NUM_TILE_W;++w) {
                if (this.tiles[h][w] != null) {
                    this.tiles[h][w].draw(g);
                }
            }
        }

        if (this.rollingButton != null) {
            this.rollingButton.draw(g);
        }

        if (GlobalState.GLOBAL_STATE.player != null) {
            GlobalState.GLOBAL_STATE.player.draw(g);
        }

        if (GlobalState.GLOBAL_STATE.computer != null) {
            GlobalState.GLOBAL_STATE.computer.draw(g);
        }
    }

    private class RollingListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (rollingButton.hit(e.getX(), e.getY())) {
                Updater.getInstance().movePlayer(Updater.getInstance().rollDice());
                Updater.getInstance().moveComputer(Updater.getInstance().rollDice());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
