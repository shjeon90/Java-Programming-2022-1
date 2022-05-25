package object;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player extends Unit implements Drawable{

    public Player(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public Ellipse2D.Double getObject() {
        return new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fill(this.getObject());
    }
}
