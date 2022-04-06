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
        if (this.globalState.getEastForest().getDragon() == null)
            this.globalState.getEastForest().setDragon(Dragon.getNewDragon());

        if (this.globalState.getWestForest().getDragon() == null)
            this.globalState.getWestForest().setDragon(Dragon.getNewDragon());

        if (this.globalState.getSouthForest().getDragon() == null)
            this.globalState.getSouthForest().setDragon(Dragon.getNewDragon());

        if (this.globalState.getNorthForest().getDragon() == null)
            this.globalState.getNorthForest().setDragon(Dragon.getNewDragon());
    }
}
