public class App {

    public static void main(String[] args) {
        GlobalState globalState = new GlobalState();
        Engine engine = new Engine();

        globalState.init();
        engine.init(globalState);

        engine.run();
    }
}
