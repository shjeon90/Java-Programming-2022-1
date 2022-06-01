package state;

import constants.Constants;
import frame.FieldTown;
import gameobject.Dragon;
import gameobject.Npc;
import gameobject.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GlobalState {
    public static GlobalState globalState = new GlobalState();
    public Player player;
    public volatile Dragon[] dragons;
    public volatile Thread[] dragonThreads;
    public FieldTown currentField;
    public List<Npc> npcs;

    public GlobalState() {
        this.player = new Player();
        this.dragons = new Dragon[Constants.MAX_DRAGON];
        this.dragonThreads = new Thread[Constants.MAX_DRAGON];

        for (int i = 0;i < Constants.MAX_DRAGON;++i) {
            this.dragons[i] = new Dragon();
            this.dragonThreads[i] = new Thread(this.dragons[i]);
        }

        this.currentField = new FieldTown(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT);
        this.npcs = new ArrayList<>();
    }

    public void init() {
        Random random = new Random();
        this.player.init(Constants.PLAYER_NAME, Constants.INITIAL_POS_X, Constants.INITIAL_POS_Y, Constants.PLAYER_HP, Constants.PLAYER_ATT, Constants.PLAYER_DEF);
//        this.dragon.init(Constants.INITIAL_POS_X, Constants.INITIAL_POS_Y, Constants.DRAGON_HP, Constants.DRAGON_ATT, Constants.DRAGON_DEF);
//        for (Dragon dragon: this.dragons) {
        for (int i = 0;i < this.dragons.length;++i) {
            int x = random.nextInt(Constants.FIELD_WIDTH);
            int y = random.nextInt(Constants.FIELD_HEIGHT);

            this.dragons[i].init(Constants.DRAGON_NAME, x, y, Constants.DRAGON_HP, Constants.DRAGON_ATT, Constants.DRAGON_DEF);
//            Thread dragonThread = new Thread(dragon);
//            dragonThread.start();
            this.dragonThreads[i].start();
        }

        for (Constants.NPC_NAMES name: Constants.NPC_NAMES.values()) {
            int x = random.nextInt(Constants.FIELD_WIDTH);
            int y = random.nextInt(Constants.FIELD_HEIGHT);
            this.npcs.add(new Npc(name.name(), x, y));
        }
    }
}
