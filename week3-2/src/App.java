import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player(80, 15, 8);
        Dragon dragon = new Dragon(100, 15, 10);

        boolean counterAtt = false;

        while (true) {
            System.out.println("status====================");
            System.out.println(dragon.toString());
            System.out.println(player.toString());
            System.out.println("==========================");
            System.out.println("menu======================");
            System.out.println("1. Fight");
            System.out.println("2. Defense");
            System.out.println("3. Run");
            System.out.println("==========================");
            System.out.print("> ");

            int chosen = scan.nextInt();
            switch (chosen) {
                case 1:
                    System.out.println("Fight with the dragon!!");
                    player.fight(dragon);

                    counterAtt = random.nextBoolean();
                    if (counterAtt) dragon.fight(player);
                    break;
                case 2:
                    player.setDef(player.getDef() * 2);

                    System.out.println("Dragon got raged!");
                    dragon.fight(player);

                    player.setDef(player.getDef() / 2);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }

            if (player.getHp() <= 0) {
                System.out.println("Player was killed. The dragon is too strong...");
                break;
            } else if (dragon.getHp() <= 0) {
                System.out.println("Player killed the dragon. You're strong!");
                break;
            }
        }
    }
}
