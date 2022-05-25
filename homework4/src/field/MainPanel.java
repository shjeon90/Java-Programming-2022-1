package field;

import constant.Constant;
import object.Tile;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private Tile[][] tiles;

    public MainPanel() {
        this.setPreferredSize(new Dimension(Constant.MAINPANEL_WIDTH, Constant.MAINPANEL_HEIGHT));
        this.setBackground(Color.GREEN);

        this.tiles = new Tile[Constant.NUM_TILE_H][Constant.NUM_TILE_W];
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
    }
}
