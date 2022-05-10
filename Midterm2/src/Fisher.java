import java.util.Scanner;

public class Fisher {
	private Fish[] caughtFishs;
	private int numOfFishs;
	private Pool pool;
	
	public Fisher(Pool pool) {
		this.pool = pool;
		this.caughtFishs = new Fish[10];
		this.numOfFishs = 0;
		for (int i = 0;i < this.caughtFishs.length;++i) {
			this.caughtFishs[i] = null;
		}
	}
	
	private void doFishing() {
		double prob = Math.random();
		Fish fish = this.pool.popFish(prob);
		if (fish != null) {
			if (this.numOfFishs < 10) {
				System.out.println("����⸦ ���ҽ��ϴ�. " + fish.toString());
				this.caughtFishs[this.numOfFishs++] = fish;
			} else System.out.println("�� �̻� ����⸦ ������ �� �����ϴ�.");
		} else System.out.println("����⸦ ���� ���߽��ϴ�.");
	}

	private void showCaughtFishs() {
		for (int i = 0;i < this.numOfFishs;++i) {
			System.out.println(this.caughtFishs[i].toString());
		}
	}
	
	private void printBehaviorList() {
		System.out.println("1. ���� �ϱ�");
		System.out.println("2. ���� ����� ����");
		System.out.println("3. ���� ����");
		System.out.print("> ");
	}
	
	public void doBehavior() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			this.printBehaviorList();
			int behavior = scan.nextInt();
			
			if (behavior == 1) {
				this.doFishing();
			} else if (behavior == 2) {
				this.showCaughtFishs();
			} else if (behavior == 3) {
				break;
			} else {
				System.out.println("�� �� �Է��߽��ϴ�.");
			}
		}
	}
}
