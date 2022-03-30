package engine;

import constant.Constant;
import object.Dragon;
import state.GlobalState;

import java.util.Random;

public class Updater {
    private GlobalState globalState;
    private Respawner respawner;

    public Updater() {
        this.respawner = new Respawner();
    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
        this.respawner.init(globalState);
    }

    private void fight() {
        if (this.globalState.getCurrentTarget() == null) return;

        Random random = new Random();
        boolean counterAtt = false;

        System.out.println("Fight with the dragon!!");
        this.globalState.player.fight(this.globalState.getCurrentTarget());

        if (this.globalState.getCurrentTarget().getHp() <= 0) {
            if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
                this.globalState.getEastForest().setDragon(null);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
                this.globalState.getWestForest().setDragon(null);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
                this.globalState.getSouthForest().setDragon(null);
            } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
                this.globalState.getNorthForest().setDragon(null);
            }
            return ;
        }

        counterAtt = random.nextBoolean();
        if (counterAtt) this.globalState.getCurrentTarget().fight(this.globalState.player);
    }

    private void defense() {
        if (this.globalState.getCurrentTarget() == null) return;

        this.globalState.player.setDef(this.globalState.player.getDef() * 2);

        System.out.println("Object.Dragon got raged!");
        this.globalState.getCurrentTarget().fight(this.globalState.player);

        this.globalState.player.setDef(this.globalState.player.getDef() / 2);
    }

    private void terminateGame() {
        System.exit(0);
    }

    private void updateForTown(int chosen) {
        switch(chosen) {
            case 1:
                this.globalState.currentField = Constant.MAP_NAME_EAST_FOREST;
                break;
            case 2:
                this.globalState.currentField = Constant.MAP_NAME_WEST_FOREST;
                break;
            case 3:
                this.globalState.currentField = Constant.MAP_NAME_SOUTH_FOREST;
                break;
            case 4:
                this.globalState.currentField = Constant.MAP_NAME_NORTH_FOREST;
                break;
            case 5:
                this.terminateGame();
                break;
            case 6:
                this.globalState.player.setHp(Constant.PLAYER_HP);
                break;
            default:
                break;
        }

        this.respawner.respawn();
    }

    private void updateForEastForest(int chosen) {
        switch(chosen) {
            case 1:
                this.fight();
                break;
            case 2:
                this.defense();
                break;
            case 3:
                this.terminateGame();
                break;
            case 4:
                this.globalState.currentField = Constant.MAP_NAME_TOWN;
                break;
            default:
                break;
        }
    }

    private void updateForWestForest(int chosen) {
        switch(chosen) {
            case 1:
                this.fight();
                break;
            case 2:
                this.defense();
                break;
            case 3:
                this.terminateGame();
                break;
            case 4:
                this.globalState.currentField = Constant.MAP_NAME_TOWN;
                break;
            default:
                break;
        }
    }

    private void updateForSouthForest(int chosen) {
        switch(chosen) {
            case 1:
                this.fight();
                break;
            case 2:
                this.defense();
                break;
            case 3:
                this.terminateGame();
                break;
            case 4:
                this.globalState.currentField = Constant.MAP_NAME_TOWN;
                break;
            default:
                break;
        }
    }

    private void updateForNorthForest(int chosen) {
        switch (chosen) {
            case 1:
                this.fight();
                break;
            case 2:
                this.defense();
                break;
            case 3:
                this.terminateGame();
                break;
            case 4:
                this.globalState.currentField = Constant.MAP_NAME_TOWN;
                break;
            default:
                break;
        }
    }

    public void update(int chosen) {
        if (this.globalState.currentField.equals(Constant.MAP_NAME_TOWN)) {
            this.updateForTown(chosen);
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
            this.updateForEastForest(chosen);
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
            this.updateForWestForest(chosen);
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
            this.updateForSouthForest(chosen);
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
            this.updateForNorthForest(chosen);
        }
    }

    public boolean checkTermination() {
        if (this.globalState.player.getHp() <= 0) {
            System.out.println("Object.Player was killed. The dragon is too strong...");
            return true;
        }  else return false;
    }
}
