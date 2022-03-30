package engine;

import constant.Constant;
import state.GlobalState;

import java.util.Scanner;

public class InputGetter {
    private GlobalState globalState;
    private Scanner scan;

    public InputGetter() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
        this.scan = new Scanner(System.in);
    }

    public int getInput() {
        while (true) {
            int chosen = scan.nextInt();
            boolean isValid = false;

            if (this.globalState.currentField.equals(Constant.MAP_NAME_TOWN)) {
                isValid = this.globalState.town.validateInput(chosen);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
                isValid = this.globalState.eastForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
                isValid = this.globalState.westForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
                isValid = this.globalState.southForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
                isValid = this.globalState.northForest.validateInput(chosen);
            }

            if (isValid) return chosen;
            else System.out.println("Wrong input!");
        }

    }
}
