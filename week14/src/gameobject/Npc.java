package gameobject;

import constants.Constants;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Npc extends Unit implements Drawable {
    private String name;

    public Npc(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Ellipse2D.Double getObject() {
        return new Ellipse2D.Double(this.x, this.y, Constants.UNIT_WIDTH, Constants.UNIT_HEIGHT);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        g2d.fill(this.getObject());

        g2d.drawString(this.name, this.x, this.y);
    }
}
