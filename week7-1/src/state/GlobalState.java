package state;

import constant.Constant;
import field.*;
import object.Dragon;
import object.Player;

public class GlobalState {
    public Player player;

    public FieldTown town;
    public FieldEastForest eastForest;
    public FieldWestForest westForest;
    public FieldSouthForest southForest;
    public FieldNorthForest northForest;
//    public String currentField;
    public Field currentField;

    public GlobalState() {
        this.player = new Player(Constant.PLAYER_HP, Constant.PLAYER_ATT, Constant.PLAYER_DEF);

        this.town = new FieldTown();
        this.eastForest = new FieldEastForest();
        this.westForest = new FieldWestForest();
        this.southForest = new FieldSouthForest();
        this.northForest = new FieldNorthForest();
    }

    public void init() {
//        this.currentField = Constant.MAP_NAME_TOWN;
        this.currentField = this.town;
    }

//    public FieldEastForest getEastForest() {
//        return eastForest;
//    }
//
//    public FieldWestForest getWestForest() {
//        return westForest;
//    }
//
//    public FieldSouthForest getSouthForest() {
//        return southForest;
//    }
//
//    public FieldNorthForest getNorthForest() {
//        return northForest;
//    }

//    public Dragon getCurrentTarget() {
//        if (this.currentField.equals(Constant.MAP_NAME_EAST_FOREST))
//            return this.eastForest.getDragon();
//        else if (this.currentField.equals(Constant.MAP_NAME_WEST_FOREST))
//            return this.westForest.getDragon();
//        else if (this.currentField.equals(Constant.MAP_NAME_SOUTH_FOREST))
//            return this.southForest.getDragon();
//        else if (this.currentField.equals(Constant.MAP_NAME_NORTH_FOREST))
//            return this.northForest.getDragon();
//        else return null;
//    }

}
