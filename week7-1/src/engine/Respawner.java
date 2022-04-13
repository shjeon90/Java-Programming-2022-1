package engine;

import object.Dragon;
import state.GlobalState;

public class Respawner {
    private GlobalState globalState;

    public Respawner () {
        this.globalState = null;
    }

    public void init (GlobalState globalState) {
        this.globalState = globalState;
    }

    public void respawn() {
        if (this.globalState.eastForest.getDragon() == null)
            this.globalState.eastForest.setDragon(Dragon.getNewDragon());

        if (this.globalState.westForest.getDragon() == null)
            this.globalState.westForest.setDragon(Dragon.getNewDragon());

        if (this.globalState.southForest.getDragon() == null)
            this.globalState.southForest.setDragon(Dragon.getNewDragon());

        if (this.globalState.northForest.getDragon() == null)
            this.globalState.northForest.setDragon(Dragon.getNewDragon());
    }
}
