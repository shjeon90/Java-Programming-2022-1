package frame;

import gameobject.Dragon;
import gameobject.Npc;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldTown extends JPanel {

    public FieldTown(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GREEN);
        FieldTownListener listener = new FieldTownListener(this);
        this.addMouseListener(listener);
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

        for (Npc npc: GlobalState.globalState.npcs) {
            npc.draw(g);
        }

    }

    class FieldTownListener implements MouseListener {
        private FieldTown obj;

        public FieldTownListener(FieldTown obj) {
            this.obj = obj;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.obj.requestFocusInWindow();
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
