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
        this.player = new Player(Constant.PLAYER_HP, Constant.PLAYER_ATT, Constant.PLAYER_DEF);
        this.dragon = new Dragon(Constant.DRAGON_HP, Constant.DRAGON_ATT, Constant.DRAGON_DEF);

        this.town = new FieldTown();
        this.eastForest = new FieldEastForest();
        this.westForest = new FieldWestForest();
        this.southForest = new FieldSouthForest();
        this.northForest = new FieldNorthForest();
    }

    public void init() {
        this.currentField = Constant.MAP_NAME_TOWN;
    }
}
