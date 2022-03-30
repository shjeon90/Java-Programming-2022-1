package engine;

import constant.Constant;
import jdk.internal.util.xml.impl.Input;
import object.item.Item;
import state.GlobalState;

import java.util.Random;
import java.util.Scanner;

public class Updater {
    private GlobalState globalState;
    private Respawner respawner;
    private InputGetter inputGetter;
    private Painter painter;

    public Updater() {
        this.respawner = new Respawner();
        this.inputGetter = null;
        this.painter = null;
    }

    public void init(GlobalState globalState, InputGetter inputGetter, Painter painter) {
        this.globalState = globalState;
        this.inputGetter = inputGetter;
        this.painter = painter;
        this.respawner.init(globalState);
    }

    private void fight() {
        if (this.globalState.getCurrentTarget() == null) return;

        Random random = new Random();
        boolean counterAtt = false;

//        System.out.println("Fight with the dragon!!");
        this.painter.printMessage("Fight with the dragon!!\n");
        this.globalState.player.fight(this.globalState.getCurrentTarget());

        if (this.globalState.getCurrentTarget().getHp() <= 0) {
            double prob = random.nextDouble();
            if (prob <= Constant.DROP_RATE) {
                Item item = this.globalState.getCurrentTarget().getItem();

//                System.out.println("got " + item.toString());
                this.painter.printMessage("got " + item.toString() + "\n");

                this.globalState.player.keepItem(item);
            }

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

//        System.out.println("Object.Dragon got raged!");
        this.painter.printMessage("Object.Dragon got raged!\n");
        this.globalState.getCurrentTarget().fight(this.globalState.player);

        this.globalState.player.setDef(this.globalState.player.getDef() / 2);
    }

    private void terminateGame() {
        System.exit(0);
    }

    private void showInventory () {
//        System.out.println("You have...");
        this.painter.printMessage("You have...\n");

        boolean flag = false;
        for (int i = 0;i < Constant.MAX_INVENTORY;++i) {
            if (this.globalState.player.getInventory()[i] != null) {
                flag = true;
                Item item = this.globalState.player.getInventory()[i];
//                System.out.println("\t" + i + ". " + item.name + ", price: " + item.price);
                this.painter.printMessage("\t" + i + ". " + item.name + ", price: " + item.price + "\n");
            }
        }

        if (!flag)
//            System.out.println("nothing...");
            this.painter.printMessage("nothing...\n");
    }

    private void sellItem () {
        this.showInventory();

//        System.out.println("Select the item to sell");
//        System.out.print("> ");
        this.painter.printMessage("Select the item to sell\n");
        this.painter.printMessage("> ");
        int chosen = this.inputGetter.getInt();

        if (((0 <= chosen) && (chosen < Constant.MAX_INVENTORY)) && this.globalState.player.getInventory()[chosen] != null) {
            Item item = this.globalState.player.getInventory()[chosen];

            this.painter.printMessage("sell " + item.toString() + "\n");

            this.globalState.player.increaseBudget(item.price);
            this.globalState.player.getInventory()[chosen] = null;
        } else this.painter.printMessage("invalid item\n");
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
            case 7:
                this.showInventory();
                break;
            case 8:
                this.sellItem();
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
            case 5:
                this.showInventory();
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
            case 5:
                this.showInventory();
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
            case 5:
                this.showInventory();
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
            case 5:
                this.showInventory();
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
//            System.out.println("Object.Player was killed. The dragon is too strong...");
            this.painter.printMessage("Object.Player was killed. The dragon is too strong...\n");
            return true;
        }  else return false;
    }
}
