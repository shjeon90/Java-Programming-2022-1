import java.util.Random;
import java.util.Scanner;

public class App {

    public static int max(int a, int b) {
        return a > b? a : b;
    }

    public static int min(int a, int b) {
        return a > b? b : a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int playerHp = 80;
        int playerAtt = 15;
        int playerDef = 8;

        int dragonHp = 100;
        int dragonAtt = 15;
        int dragonDef = 10;

        boolean isCritical = false;
        boolean counterAtt = false;
        int damage = 0;

        while (true) {
            System.out.println("status====================");
            System.out.println("> Dragon");
            System.out.println("\thp: " + dragonHp);
            System.out.println("\tatt: " + dragonAtt);
            System.out.println("\tdef: " + dragonDef);
            System.out.println("> Player");
            System.out.println("\thp: " + playerHp);
            System.out.println("\tatt: " + playerAtt);
            System.out.println("\tdef: " + playerDef);
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
                    isCritical = random.nextBoolean();
                    damage = max(playerAtt * (isCritical ? 2 : 1) - dragonDef, 0);
                    System.out.println("hit the dragon with " + damage + " att");
                    dragonHp -= damage;
                    dragonHp = max(dragonHp, 0);

                    counterAtt = random.nextBoolean();
                    if (counterAtt) {
                        System.out.println("Dragon got raged!");
                        isCritical = random.nextBoolean();
                        damage = max(dragonAtt * (isCritical ? 2 : 1) - playerDef, 0);
                        System.out.println("got " + damage + " damages");
                        playerHp -= damage;
                        playerHp = max(playerHp, 0);
                    }
                    break;
                case 2:
                    playerDef *= 2;

                    System.out.println("Dragon got raged!");
                    isCritical = random.nextBoolean();
                    damage = max(dragonAtt * (isCritical ? 2 : 1) - playerDef, 0);
                    System.out.println("got " + damage + " damages");
                    playerHp -= damage;
                    playerHp = max(playerHp, 0);

                    playerDef /= 2;
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }

            if (playerHp <= 0) {
                System.out.println("Player was killed. The dragon is too strong...");
                break;
            } else if (dragonHp <= 0) {
                System.out.println("Player killed the dragon. You're strong!");
                break;
            }
        }
    }
}
