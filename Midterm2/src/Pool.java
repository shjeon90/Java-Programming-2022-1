
public class Pool {
	private static final Pool uniquePool = new Pool();
	private Fish[] fishs;
	
	public Pool() {
		this.fishs = new Fish[10];
		for (int i = 0;i < fishs.length;++i) {
			int size = 10 + (int)(Math.random() * 20);
			int fname = (int)(Math.random() * 10) % 5;
			this.fishs[i] = new Fish(Constants.FISH_NAMES[fname], size);
		}
	}
	
	public static Pool getInstance() {
		return uniquePool;
	}
	
	public Fish popFish(double prob) {
		if (prob > 0.7) {
			int ind = (int) (Math.random() * 10);
			Fish caughtFish = this.fishs[ind];
			this.fishs[ind] = null;
			return caughtFish;
		}
		return null;
	}
}
