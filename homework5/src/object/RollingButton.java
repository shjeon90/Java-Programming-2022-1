package object;

import constant.Constant;

import java.awt.*;

public class RollingButton implements Drawable {
    private int x;
    private int y;

    public RollingButton(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getObject() {
        return new Rectangle(this.x, this.y, Constant.BTN_WIDTH, Constant.BTN_HEIGHT);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        ((Graphics2D) g).fill(this.getObject());
    }

    public boolean hit(int mx, int my) {
        return this.getObject().intersects(new Rectangle(mx - 1, my - 1, 2, 2));
    }
}
