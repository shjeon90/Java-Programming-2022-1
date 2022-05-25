package state;

import field.MainPanel;

public class GlobalState {
    public MainPanel mainPanel;

    public GlobalState () {
        this.mainPanel = new MainPanel();
    }

    public void init() {
        this.mainPanel.init();
    }
}
