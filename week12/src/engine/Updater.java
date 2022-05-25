package engine;

import constants.Constants;
import gameobject.Dragon;
import item.HealingPotion;
import item.Item;
import item.Sword;
import state.GlobalState;

import java.util.Random;

public class Updater implements Manager{
    private Painter painter;

    public Updater() {

    }

    public void init(Painter painter) {
        this.painter = painter;
    }

    public void movePlayer(int dx, int dy) {
        if (GlobalState.globalState.player != null) {
            int curX = GlobalState.globalState.player.getX();
            int curY = GlobalState.globalState.player.getY();

            GlobalState.globalState.player.setX(curX + dx);
            GlobalState.globalState.player.setY(curY + dy);
        }

        this.painter.update();
    }

    public void attack() {
        if (GlobalState.globalState.player == null) return;
        Random random = new Random();

        for (int i = 0;i < GlobalState.globalState.dragons.length;++i) {
            Dragon dragon = GlobalState.globalState.dragons[i];
            if (dragon != null && dragon.hit(GlobalState.globalState.player)) {
                GlobalState.globalState.player.fight(dragon);

                if (dragon.getHp() <= 0) {
                    double prob = random.nextDouble();
                    if (prob <= Constants.DROP_RATE) {
                        Item item = GlobalState.globalState.dragons[i].getItem();
                        GlobalState.globalState.player.addItem(item);
                    }

                    GlobalState.globalState.dragons[i] = null;
                } else if (random.nextBoolean()) {
                    dragon.fight(GlobalState.globalState.player);
                    if (GlobalState.globalState.player.getHp() <= 0) {
                        GlobalState.globalState.player = null;
                    }
                }

                break;
            }
        }

        this.painter.update();
    }

    public void sellItem(Item item) {
        int newBudget = GlobalState.globalState.player.getBudget() + item.getPrice();
        GlobalState.globalState.player.setBudget(newBudget);
        GlobalState.globalState.player.getInventory().remove(item);
        this.painter.update();
    }

    public void healHp(HealingPotion item) {
        int amount = item.getAmount();
        int newHp = Math.min(GlobalState.globalState.player.getHp() + amount, Constants.PLAYER_HP);
        GlobalState.globalState.player.setHp(newHp);
        GlobalState.globalState.player.getInventory().remove(item);
        this.painter.update();
    }

    public void equipSword(Sword sword) {
        int newAtt = GlobalState.globalState.player.getAtt() + sword.getAtt();
        GlobalState.globalState.player.setAtt(newAtt);
        GlobalState.globalState.player.setSword(sword);
        GlobalState.globalState.player.getInventory().remove(sword);
        this.painter.update();
    }
}
