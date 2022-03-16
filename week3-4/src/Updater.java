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
                this.globalState.currentField = "eastForest";
                break;
            case 2:
                this.globalState.currentField = "westForest";
                break;
            case 3:
                this.globalState.currentField = "southForest";
                break;
            case 4:
                this.globalState.currentField = "northForest";
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
        if (this.globalState.currentField.equals("town")) {
            this.updateForTown(chosen);
        } else if (this.globalState.currentField.equals("eastForest")) {
            this.updateForEastForest(chosen);
        } else if (this.globalState.currentField.equals("westForest")) {
            this.updateForWestForest(chosen);
        } else if (this.globalState.currentField.equals("southForest")) {
            this.updateForSouthForest(chosen);
        } else if (this.globalState.currentField.equals("northForest")) {
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
