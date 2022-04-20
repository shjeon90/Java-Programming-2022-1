package gameobject;

import java.awt.*;

public class Player extends Unit {

    public Player() {

    }

    @Override
    public void draw(Graphics g) {
//        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.draw(this.getObject());
    }
}
