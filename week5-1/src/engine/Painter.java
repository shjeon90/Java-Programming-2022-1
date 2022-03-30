package engine;

import constant.Constant;
import state.GlobalState;

public class Painter {
    private GlobalState globalState;

    public Painter() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
    }

    private void paintStatus() {
        System.out.println("status====================");
        if (!this.globalState.currentField.equals(Constant.MAP_NAME_TOWN) && this.globalState.getCurrentTarget() != null)
            System.out.println(this.globalState.getCurrentTarget().toString());
        System.out.println(this.globalState.player.toString());
        System.out.println("==========================");
    }

    private void paintMenu() {
        if (this.globalState.currentField.equals(Constant.MAP_NAME_TOWN)) {
            System.out.print(this.globalState.town.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
            System.out.print(this.globalState.eastForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
            System.out.print(this.globalState.westForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
            System.out.print(this.globalState.southForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
            System.out.print(this.globalState.northForest.getMenu());
        }
    }

    public void paint() {
        this.paintStatus();
        this.paintMenu();
    }
}
