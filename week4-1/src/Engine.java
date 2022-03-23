public class Engine {
    private GlobalState globalState;
    private Painter painter;
    private InputGetter inputGetter;
    private Updater updater;

    public Engine() {
        this.globalState = null;
        this.painter = new Painter();
        this.inputGetter = new InputGetter();
        this.updater = new Updater();
    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
        this.painter.init(globalState);
        this.inputGetter.init(globalState);
        this.updater.init(globalState);
    }

    public void run() {

        do {
            this.painter.paint();
            int chosen = this.inputGetter.getInput();
            this.updater.update(chosen);

        } while (!this.updater.checkTermination());
    }
}
