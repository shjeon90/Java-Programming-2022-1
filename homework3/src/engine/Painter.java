package engine;

import state.GlobalState;

public class Painter {
    private GlobalState globalState;

    public Painter() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
    }

    public void paintMsg(String msg) {
        System.out.print(msg);
    }

    private void paintBoard() {
        this.paintMsg(this.globalState.gameBoard.toString());
    }

    private void paintMenu() {

    }

    public void paint(boolean turnPlayer) {
        if (turnPlayer) {
            this.paintMsg("player turn\n");
        } else {
            this.paintMsg("computer turn\n");
        }
        this.paintBoard();
        this.paintMsg("how many times will you roll the dice (1~3)? ");
    }
}
