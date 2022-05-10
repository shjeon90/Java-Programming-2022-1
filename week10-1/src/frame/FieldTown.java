package frame;

import gameobject.Dragon;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;

public class FieldTown extends JPanel {

    public FieldTown(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GREEN);
    }

    public void init() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (GlobalState.globalState.player != null) {
            GlobalState.globalState.player.draw(g);
        }

        for (Dragon dragon: GlobalState.globalState.dragons) {
            if (dragon != null) {
                dragon.draw(g);
            }
        }

    }
}
