
public class Thanos {
	private InfinityGauntlet infinityGauntlet;
	
	public Thanos() {
		
	}

	public InfinityGauntlet getInfinityGauntlet() {
		return infinityGauntlet;
	}

	public void setInfinityGauntlet(InfinityGauntlet infinityGauntlet) {
		System.out.println("Thanos has the Infinity Gauntlet.");
		this.infinityGauntlet = infinityGauntlet;
	}
	
	public void collectStones (MindStone mindStone, PowerStone powerStone, RealityStone realityStone, SoulStone soulStone, TimeStone timeStone) {
		System.out.println("Thanos collects the infinity stones.");
		this.infinityGauntlet.setMindStone(mindStone);
		this.infinityGauntlet.setPowerStone(powerStone);
		this.infinityGauntlet.setRealityStone(realityStone);
		this.infinityGauntlet.setSoulStone(soulStone);
		this.infinityGauntlet.setTimeStone(timeStone);
	}
	
	public void doFingerSnap() {
		System.out.println("Thanos do finger snap.");
		if (this.infinityGauntlet.isFullStones()) System.out.println("I'm inevitable.");
		else System.out.println("?");
	}
}
