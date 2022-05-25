package engine;

import state.GlobalState;

public class Engine {
    private static Engine unique_engine = new Engine();

    private InputGetter inputGetter;
    private Updater updater;
    private Painter painter;

    public Engine() {
        this.updater = new Updater();
        this.inputGetter = new InputGetter();
        this.painter = new Painter();
    }

    public static Engine getInstance() {
        return unique_engine;
    }

    public void init() {
        GlobalState.globalState.init();

        this.painter.init();
        this.updater.init(this.painter);
        this.inputGetter.init(this.updater);
        this.painter.setUpdater(this.updater);

        this.painter.switchField(this.inputGetter);
    }

}
