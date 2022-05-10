package subpanel;

import constants.Constants;
import item.Item;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    private static final InventoryPanel inventoryPanel = new InventoryPanel();
    private JList<Item> inventory;

    public InventoryPanel() {
        this.setPreferredSize(new Dimension(Constants.INVENTORYPANEL_WIDTH, Constants.INVENTORYPANEL_HEIGHT));
        this.setBackground(Color.RED);

        this.inventory = new JList<>();
    }

    public static InventoryPanel getInstance() {
        return inventoryPanel;
    }

    public void init() {
        JScrollPane scrollPane = new JScrollPane(this.inventory);
        scrollPane.setPreferredSize(new Dimension(Constants.INVENTORYPANEL_WIDTH, Constants.INVENTORYPANEL_HEIGHT));
        this.add(scrollPane);
    }

    public void update() {
        if (GlobalState.globalState.player != null) {
            this.inventory.setListData(GlobalState.globalState.player.getInventory());
        }
    }
}
