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

    private void handleWrongInput() {
        System.out.println("Wrong input!");
    }

    public void update(int chosen) {


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
            default:
                this.handleWrongInput();
                break;
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
