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
        while (true) {
            int chosen = scan.nextInt();
            boolean isValid = false;

            if (this.globalState.currentField.equals("town")) {
                isValid = this.globalState.town.validateInput(chosen);
            } else if (this.globalState.currentField.equals("eastForest")) {
                isValid = this.globalState.eastForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals("westForest")) {
                isValid = this.globalState.westForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals("southForest")) {
                isValid = this.globalState.southForest.validateInput(chosen);
            } else if (this.globalState.currentField.equals("northForest")) {
                isValid = this.globalState.northForest.validateInput(chosen);
            }

            if (isValid) return chosen;
            else System.out.println("Wrong input!");
        }

    }
}
