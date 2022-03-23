import java.util.Random;

public class Updater {
    private GlobalState globalState;

    public Updater() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
    }

    private void fight() {
        Random random = new Random();
        boolean counterAtt = false;

        System.out.println("Fight with the dragon!!");
        this.globalState.player.fight(this.globalState.dragon);

        counterAtt = random.nextBoolean();
        if (counterAtt) this.globalState.dragon.fight(this.globalState.player);
    }

    private void defense() {
        this.globalState.player.setDef(this.globalState.player.getDef() * 2);

        System.out.println("Dragon got raged!");
        this.globalState.dragon.fight(this.globalState.player);

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
            default:
                break;
        }
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
            default:
                break;
        }
    }

    private void updateForNorthForest(int chosen) {
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
            System.out.println("Player was killed. The dragon is too strong...");
            return true;
        } else if (this.globalState.dragon.getHp() <= 0) {
            System.out.println("Player killed the dragon. You're strong!");
            return true;
        } else return false;
    }
}
