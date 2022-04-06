package engine;

import state.GlobalState;

public class Engine {
    private static Engine unique_engine = new Engine();
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

    public void init() {
        this.globalState.init();
        this.painter.init(this.globalState);
        this.inputGetter.init(this.globalState, this.painter);
        this.updater.init(this.globalState, this.painter);
    }

    public static Engine getInstance() {
        return unique_engine;
    }

    public void run() {
        this.painter.paintMsg("start a game\n");

        boolean turnPlayer = true;

        do {
            this.painter.paint(turnPlayer);
            int chosen = this.inputGetter.getInt(turnPlayer);
            this.updater.update(chosen, turnPlayer);
            turnPlayer = !turnPlayer;
        } while (!this.updater.checkTermination());

        if (this.globalState.completeComputer == 3) {
            this.painter.paintMsg("Computer win!\n");
        } else {
            this.painter.paintMsg("Player win!\n");
        }
    }
}
