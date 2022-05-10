package gameobject;

import java.awt.*;

public class Dragon extends Unit {

    public Dragon() {

    }

    @Override
    public void draw(Graphics g) {
//        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(this.getObject());
    }
}
