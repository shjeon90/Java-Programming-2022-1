public class GlobalState {
    public Player player;
    public Dragon dragon;

    public GlobalState() {
        this.player = new Player(80, 15, 8);
        this.dragon = new Dragon(100, 15, 10);
    }
}
