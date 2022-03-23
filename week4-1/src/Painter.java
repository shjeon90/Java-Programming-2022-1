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
        if (this.globalState.currentField.equals(Constant.MAP_NAME_TOWN)) {
            System.out.print(this.globalState.town.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_EAST_FOREST)) {
            System.out.println(this.globalState.eastForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_WEST_FOREST)) {
            System.out.println(this.globalState.westForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST)) {
            System.out.println(this.globalState.southForest.getMenu());
        } else if (this.globalState.currentField.equals(Constant.MAP_NAME_NORTH_FOREST)) {
            System.out.println(this.globalState.northForest.getMenu());
        }
    }

    public void paint() {
        this.paintStatus();
        this.paintMenu();
    }
}
