package state;

import field.GameBoard;
import object.Computer;
import object.Player;

public class GlobalState {
    public Player player;
    public Computer computer;
    public GameBoard gameBoard;
    public int completePlayer;
    public int completeComputer;

    public GlobalState() {
        this.player = new Player();
        this.computer = new Computer();
        this.gameBoard = new GameBoard();
    }

    public void init () {
        this.completePlayer = 0;
        this.completeComputer = 0;
        this.gameBoard.init();
        this.gameBoard.setPlayer(this.player);
        this.gameBoard.setComputer(this.computer);
    }
}
