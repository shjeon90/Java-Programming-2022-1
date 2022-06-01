package engine;

import state.GlobalState;

public class Engine {

    private static final Engine unique_engine = new Engine();
    private InputGetter inputGetter;
    private Painter painter;
    private Updater updater;

    public Engine() {
        this.inputGetter = new InputGetter();
        this.painter = new Painter();
        this.updater = new Updater();
    }

    public static Engine getInstance() {
        return unique_engine;
    }

    public void init() {
        GlobalState.GLOBAL_STATE.init();
        this.painter.init();
    }
}
