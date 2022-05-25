package engine;

import constants.Constants;
import state.GlobalState;
import subpanel.SubPanel;

import javax.swing.*;
import java.awt.*;

public class Painter extends JFrame implements Manager{
    private SubPanel subPanel;
    private Updater updater;

    public Painter() {
        this.subPanel = SubPanel.getInstance();
    }

    public void init() {
        this.subPanel.init();

        this.setLayout(new BorderLayout());
        this.setTitle(Constants.MAIN_FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(this.subPanel, BorderLayout.EAST);

        this.setVisible(true);
    }

    public void setUpdater(Updater updater) {
        this.updater = updater;
        this.subPanel.setUpdater(updater);
    }

    public void switchField(InputGetter inputGetter) {
        this.add(GlobalState.globalState.currentField, BorderLayout.CENTER);
        this.pack();

        GlobalState.globalState.currentField.addKeyListener(inputGetter);
        GlobalState.globalState.currentField.setFocusable(true);
        GlobalState.globalState.currentField.requestFocusInWindow();
    }

    public void update() {
        this.subPanel.update();
        GlobalState.globalState.currentField.repaint();
    }
}
