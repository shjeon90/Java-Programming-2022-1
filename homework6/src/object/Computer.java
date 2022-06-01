package object;

import constant.Constant;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Computer extends Unit implements Drawable{

    public Computer(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public Ellipse2D.Double getObject() {
//        return new Ellipse2D.Double(this.x, this.y, this.w, this.h);
        return new Ellipse2D.Double(
                (this.x * Constant.TILE_WIDTH) + ((Constant.TILE_WIDTH - Constant.UNIT_WIDTH) / 2),
                (this.y * Constant.TILE_HEIGHT) + ((Constant.TILE_HEIGHT - Constant.UNIT_HEIGHT) / 2) + Constant.UNIT_HEIGHT / 2,
                this.w, this.h
        );
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fill(this.getObject());
    }
}
