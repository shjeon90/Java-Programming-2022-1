public class GlobalState {
    public Player player;
    public Dragon dragon;

    public FieldTown town;
    public FieldEastForest eastForest;
    public FieldWestForest westForest;
    public FieldSouthForest southForest;
    public FieldNorthForest northForest;
    public String currentField;

    public GlobalState() {
        this.player = new Player(80, 15, 8);
        this.dragon = new Dragon(100, 15, 10);

        this.town = new FieldTown();
        this.eastForest = new FieldEastForest();
        this.westForest = new FieldWestForest();
        this.southForest = new FieldSouthForest();
        this.northForest = new FieldNorthForest();
    }

    public void init() {
        this.currentField = "town";
    }
}
