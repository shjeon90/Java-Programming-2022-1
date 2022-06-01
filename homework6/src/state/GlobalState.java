package state;

import constant.Constant;
import field.MainPanel;
import object.Computer;
import object.Player;

public class GlobalState {
    public static final GlobalState GLOBAL_STATE = new GlobalState();
    public MainPanel mainPanel;
    public Player player;
    public Computer computer;

    public GlobalState () {
        this.mainPanel = new MainPanel();
//        this.player = new Player(
//                (Constant.TILE_WIDTH - Constant.UNIT_WIDTH) / 2,
//                (Constant.TILE_HEIGHT - Constant.UNIT_HEIGHT) / 2 + Constant.UNIT_HEIGHT / 2,
//                Constant.UNIT_WIDTH, Constant.UNIT_HEIGHT
//        );
//        this.computer = new Computer(
//                (Constant.TILE_WIDTH - Constant.UNIT_WIDTH) / 2,
//                (Constant.TILE_HEIGHT - Constant.UNIT_HEIGHT) / 2 - Constant.UNIT_HEIGHT / 2,
//                Constant.UNIT_WIDTH, Constant.UNIT_HEIGHT
//        );
//        System.out.println((Constant.TILE_WIDTH - Constant.UNIT_WIDTH) / 2);
//        System.out.println((Constant.TILE_HEIGHT - Constant.UNIT_HEIGHT) / 2 + Constant.UNIT_HEIGHT / 2);
        this.player = new Player(0, 0, Constant.UNIT_WIDTH, Constant.UNIT_HEIGHT);
        this.computer = new Computer(0, 0, Constant.UNIT_WIDTH, Constant.UNIT_HEIGHT);
    }

    public void init() {
        this.mainPanel.init();
    }

    public void reset() {
        this.player.setX(0);
        this.player.setY(0);
        this.computer.setX(0);
        this.computer.setY(0);
        this.player.setRound(0);
        this.computer.setRound(0);
    }
}
