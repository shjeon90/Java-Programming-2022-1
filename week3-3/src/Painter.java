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
        System.out.println("menu======================");
        System.out.println("1. Fight");
        System.out.println("2. Defense");
        System.out.println("3. Run");
        System.out.println("==========================");
        System.out.print("> ");
    }

    public void paint() {
        this.paintStatus();
        this.paintMenu();
    }
}
