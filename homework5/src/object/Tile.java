package object;

import constant.Constant;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Tile {
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle2D.Double getObject() {
        return new Rectangle2D.Double(this.x, this.y, Constant.TILE_WIDTH, Constant.TILE_HEIGHT);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(this.getObject());
    }

}
