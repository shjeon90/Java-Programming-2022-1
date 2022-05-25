package engine;

import state.GlobalState;

public class Engine {

    private static final Engine unique_engine = new Engine();
    private InputGetter inputGetter;
    private Painter painter;
    private Updater updater;
    private GlobalState globalState;

    public Engine() {
        this.inputGetter = new InputGetter();
        this.painter = new Painter();
        this.updater = new Updater();
        this.globalState = new GlobalState();
    }

    public static Engine getInstance() {
        return unique_engine;
    }

    public void init() {
        this.globalState.init();
        this.painter.init(this.globalState);
    }
}
