public class Painter {
    private GlobalState globalState;

    public Painter() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
    }

    private void paintStatus() {
        System.out.println("status====================");
        System.out.println(this.globalState.dragon.toString());
        System.out.println(this.globalState.player.toString());
        System.out.println("==========================");
    }

    private void paintMenu() {
        if (this.globalState.currentField.equals("town")) {
            System.out.print(this.globalState.town.getMenu());
        } else if (this.globalState.currentField.equals("eastForest")) {
            System.out.println(this.globalState.eastForest.getMenu());
        } else if (this.globalState.currentField.equals("westForest")) {
            System.out.println(this.globalState.westForest.getMenu());
        } else if (this.globalState.currentField.equals("southForest")) {
            System.out.println(this.globalState.southForest.getMenu());
        } else if (this.globalState.currentField.equals("northForest")) {
            System.out.println(this.globalState.northForest.getMenu());
        }
    }

    public void paint() {
        this.paintStatus();
        this.paintMenu();
    }
}
