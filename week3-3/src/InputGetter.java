import java.util.Scanner;

public class InputGetter {
    private GlobalState globalState;
    private Scanner scan;

    public InputGetter() {

    }

    public void init(GlobalState globalState) {
        this.globalState = globalState;
        this.scan = new Scanner(System.in);
    }

    public int getInput() {
        return scan.nextInt();
    }
}
