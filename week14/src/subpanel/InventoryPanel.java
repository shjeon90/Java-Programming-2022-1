package subpanel;

import constants.Constants;
import engine.Updater;
import item.DragonClaw;
import item.HealingPotion;
import item.Item;
import item.Sword;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class InventoryPanel extends JPanel {
    private static final InventoryPanel inventoryPanel = new InventoryPanel();
    private JList<Item> inventory;
    private Updater updater;

    public InventoryPanel() {
        this.setPreferredSize(new Dimension(Constants.INVENTORYPANEL_WIDTH, Constants.INVENTORYPANEL_HEIGHT));
        this.setBackground(Color.RED);

        this.inventory = new JList<>();
        ListListener listener = new ListListener();
        this.inventory.addMouseListener(listener);
    }

    public static InventoryPanel getInstance() {
        return inventoryPanel;
    }

    public void init() {
        JScrollPane scrollPane = new JScrollPane(this.inventory);
        scrollPane.setPreferredSize(new Dimension(Constants.INVENTORYPANEL_WIDTH, Constants.INVENTORYPANEL_HEIGHT));
        this.add(scrollPane);
    }

    public void setUpdater(Updater updater) {
        this.updater = updater;
    }

    public void update() {
        if (GlobalState.globalState.player != null) {
//            this.inventory.setListData(GlobalState.globalState.player.getInventory());
            Vector<Item> vec = new Vector<>(GlobalState.globalState.player.getInventory());
            this.inventory.setListData(vec);
        }
    }

    class ListListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                if (e.getSource() instanceof JList) {
                    int idx = inventory.locationToIndex(e.getPoint());
                    Item item = inventory.getModel().getElementAt(idx);
                    if (item instanceof DragonClaw) {
                        updater.sellItem(item);
                    } else if (item instanceof HealingPotion) {
                        updater.healHp((HealingPotion) item);
                    } else if (item instanceof Sword) {
                        updater.equipSword((Sword) item);
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

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
