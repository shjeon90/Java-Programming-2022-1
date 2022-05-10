
public class MCU {
	private static final MCU universe = new MCU();
	private boolean dawnOfTheUniverse;
	private MindStone mindStone;
	private PowerStone powerStone;
	private RealityStone realityStone;
	private SoulStone soulStone;
	private TimeStone timeStone;
	
	
	public MCU () {
		this.dawnOfTheUniverse = false;
	}
	
	public static MCU getInstance() {
		return universe;
	}
	
	private void bigBang() {
		System.out.println("dawn of the universe!");
		this.dawnOfTheUniverse = true;
		
		System.out.println("the big bang sent six elemental crystals...");
		this.mindStone = MindStone.getInstance();
		this.powerStone = PowerStone.getInstance();
		this.realityStone = RealityStone.getInstance();
		this.soulStone = SoulStone.getInstance();
		this.timeStone = TimeStone.getInstance();
	}
	
	public void run() {
		this.bigBang();
		
		if (this.dawnOfTheUniverse) {
			Thanos thanos = new Thanos();
			InfinityGauntlet infinityGauntlet = new InfinityGauntlet();
			thanos.setInfinityGauntlet(infinityGauntlet);
			thanos.collectStones(mindStone, powerStone, realityStone, soulStone, timeStone);
			
			thanos.doFingerSnap();
		}
	}
}
