package engine;

import constant.Constant;
import state.GlobalState;

import javax.swing.*;

public class Painter extends JFrame {
    private static final Painter unique_frame = new Painter();

    public Painter() {
    }

    public static Painter getInstance() {
        return unique_frame;
    }


    public void init() {
        this.add(GlobalState.GLOBAL_STATE.mainPanel);
        this.pack();

        this.setTitle(Constant.MAINFRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void update() {
        GlobalState.GLOBAL_STATE.mainPanel.repaint();
    }
}
