package subpanel;

import constants.Constants;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel {
    private static final StatPanel statPanel = new StatPanel();
    private PropertyPanel namePanel;
    private PropertyPanel hpPanel;
    private PropertyPanel attPanel;
    private PropertyPanel defPanel;
    private PropertyPanel budgetPanel;

    public StatPanel() {
        this.setPreferredSize(new Dimension(Constants.STATPANEL_WIDTH, Constants.STATPANEL_HEIGHT));
        this.setBackground(Color.BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.namePanel = new PropertyPanel(Constants.LABEL_NAME);
        this.hpPanel = new PropertyPanel(Constants.LABEL_HP);
        this.attPanel = new PropertyPanel(Constants.LABEL_ATT);
        this.defPanel = new PropertyPanel(Constants.LABEL_DEF);
        this.budgetPanel = new PropertyPanel(Constants.LABEL_BEDGET);
    }

    public static StatPanel getInstance() {
        return statPanel;
    }

    public void init() {
        this.namePanel.setText(GlobalState.globalState.player.getName());

        this.update();

        this.add(this.namePanel);
        this.add(this.hpPanel);
        this.add(this.attPanel);
        this.add(this.defPanel);
        this.add(this.budgetPanel);
    }

    public void update() {
        if (GlobalState.globalState.player != null) {
            this.hpPanel.setText(GlobalState.globalState.player.getHp() + "");
            this.attPanel.setText(GlobalState.globalState.player.getAtt() + "");
            this.defPanel.setText(GlobalState.globalState.player.getDef() + "");
            this.budgetPanel.setText(GlobalState.globalState.player.getBudget() + "");
        }
    }

    class PropertyPanel extends JPanel {

        protected JLabel label;
        protected JTextField textField;

        public PropertyPanel(String labelStr) {
            this.setBackground(Color.WHITE);
            this.setLayout(new FlowLayout());
            this.label = new JLabel(labelStr);
            this.textField = new JTextField(Constants.TEXTFIELD_SIZE);
            this.textField.setEditable(false);
            this.add(this.label);
            this.add(this.textField);
        }

        public void setText(String line) {
            this.textField.setText(line);
        }
    }
}
