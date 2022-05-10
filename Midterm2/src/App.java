
public class App {

	public static void main(String[] args) {
		Pool pool = Pool.getInstance();
		Fisher fisher = new Fisher(pool);
		fisher.doBehavior();
	}

}
