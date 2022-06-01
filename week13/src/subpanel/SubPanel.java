package subpanel;

import constants.Constants;
import engine.Updater;

import javax.swing.*;
import java.awt.*;

public class SubPanel extends JPanel {
    private static final SubPanel uniquePanel = new SubPanel();
    private Updater updater;
    private StatPanel statPanel;
    private InventoryPanel inventoryPanel;

    public SubPanel() {
        this.setPreferredSize(new Dimension(Constants.SUBPANEL_WIDTH, Constants.SUBPANEL_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        this.statPanel = StatPanel.getInstance();
        this.inventoryPanel = InventoryPanel.getInstance();
    }

    public static SubPanel getInstance() {
        return uniquePanel;
    }

    public void init() {
        this.statPanel.init();
        this.inventoryPanel.init();

        this.add(this.statPanel, BorderLayout.NORTH);
        this.add(this.inventoryPanel, BorderLayout.SOUTH);
    }

    public void setUpdater(Updater updater) {
        this.updater = updater;
        this.inventoryPanel.setUpdater(updater);
    }

    public void update() {
        this.statPanel.update();
        this.inventoryPanel.update();
    }

}
