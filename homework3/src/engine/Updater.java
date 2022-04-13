package engine;

import constant.Constant;
import state.GlobalState;

import java.util.Random;

public class Updater {
    private GlobalState globalState;
    private Painter painter;

    public Updater() {

    }

    public void init(GlobalState globalState, Painter painter) {
        this.globalState = globalState;
        this.painter = painter;
    }

    private void move(int d, boolean turnPlayer) {
        if (turnPlayer) {
            int curX = this.globalState.player.getX();
            int curY = this.globalState.player.getY();

            for (int i = 0;i < d;++i) {
                this.globalState.gameBoard.setPlayerWithNull(curX, curY);

                if (curY == 0 && curX != Constant.BOARD_WIDTH-1) {
                    curX++;
                } else if (curY == Constant.BOARD_HEIGHT-1 && curX != 0) {
                    curX--;
                } else if (curX == 0) {
                    curY--;
                } else if (curX == Constant.BOARD_WIDTH-1) {
                    curY++;
                }

                if (curX == 0 && curY == 0) this.globalState.completePlayer++;

                this.globalState.player.setX(curX);
                this.globalState.player.setY(curY);
                this.globalState.gameBoard.setPlayer(this.globalState.player);
            }
        } else {
            int curX = this.globalState.computer.getX();
            int curY = this.globalState.computer.getY();

            for (int i = 0;i < d;++i) {
                this.globalState.gameBoard.setComputerWithNull(curX, curY);

                if (curY == 0 && curX != Constant.BOARD_WIDTH-1) {
                    curX++;
                } else if (curY == Constant.BOARD_HEIGHT-1 && curX != 0) {
                    curX--;
                } else if (curX == 0) {
                    curY--;
                } else if (curX == Constant.BOARD_WIDTH-1) {
                    curY++;
                }

                if (curX == 0 && curY == 0) this.globalState.completeComputer++;

                this.globalState.computer.setX(curX);
                this.globalState.computer.setY(curY);
                this.globalState.gameBoard.setComputer(this.globalState.computer);
            }
        }
    }

    public void update(int chosen, boolean turnPlayer) {
        Random random = new Random();

        int sum = 0;
        for (int i = 0;i < chosen;++i) {
            int r = random.nextInt(6) + 1;
            this.painter.paintMsg("\t" + (i + 1) + ". dice: " + r + "\n");
            sum += r;
        }
        sum = sum / chosen;
        this.painter.paintMsg("average number: " + sum + "\n");

        this.move(sum, turnPlayer);
    }

    public boolean checkTermination() {
        return this.globalState.completeComputer == 3 || this.globalState.completePlayer == 3;
    }
}
