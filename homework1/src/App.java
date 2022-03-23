import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        int position = 0;

        System.out.println("start the game in position 0");

        while (true) {
            System.out.print("how many times will you roll the dice (1~3)? ");
            int chosen = scan.nextInt();
            if (chosen <= 0 || chosen > 3) {
                System.out.println("wrong input");
                continue;
            }
            int sum = 0;
            for (int i = 0;i < chosen;++i) {
                int r = random.nextInt(6) + 1;
                System.out.println("\t" + (i+1) + ". dice: " + r);
                sum += r;
            }
            sum  = sum / chosen;
            System.out.println("average number: " + sum);

            position += sum;
            if (position >= 20) {
                position %= 20;

                System.out.println("new position: " + position);
                System.out.println((count + 1) + "th round complete!");

                position = 0;
                count++;
            } else {
                System.out.println("new position: " + position);
            }

            if (count >= 3) break;
            System.out.println();

        }

        System.out.println("congratulations!");
    }
}
