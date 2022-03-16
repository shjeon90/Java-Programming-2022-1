import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        GlobalState globalState = new GlobalState();
        Engine engine = new Engine();
        engine.init(globalState);

        engine.run();
    }
}
