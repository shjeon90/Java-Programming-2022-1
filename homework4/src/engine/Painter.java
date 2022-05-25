package engine;

import constant.Constant;
import field.MainPanel;
import state.GlobalState;

import javax.swing.*;

public class Painter extends JFrame {
    private static final Painter unique_frame = new Painter();

    public Painter() {
    }

    public static Painter getInstance() {
        return unique_frame;
    }


    public void init(GlobalState globalState) {
        this.add(globalState.mainPanel);
        this.pack();

        this.setTitle(Constant.MAINFRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
