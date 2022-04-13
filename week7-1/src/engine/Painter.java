package engine;

import constant.Constant;
import state.GlobalState;

public class Painter {
    private GlobalState globalState;

    public Painter() {

    }

    public void printMessage(String msg) {
        System.out.print(msg);
    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
    }

    private void paintStatus() {
        System.out.println("status====================");
        if (!this.globalState.currentField.equals(Constant.MAP_NAME_TOWN) && this.globalState.currentField.getDragon() != null)
            System.out.println(this.globalState.currentField.getDragon().toString());
        System.out.println(this.globalState.player.toString());
        System.out.println("==========================");
    }

    private void paintMenu() {
        System.out.println(this.globalState.currentField.getMenu());
//        if (this.globalState.currentField.equals(Constant.MAP_NAME_TOWN)) {
//            System.out.print(this.globalState.town.getMenu());
//        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
//            System.out.print(this.globalState.eastForest.getMenu());
//        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
//            System.out.print(this.globalState.westForest.getMenu());
//        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
//            System.out.print(this.globalState.southForest.getMenu());
//        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
//            System.out.print(this.globalState.northForest.getMenu());
//        }
    }

    public void paint() {
        this.paintStatus();
        this.paintMenu();
    }
}
