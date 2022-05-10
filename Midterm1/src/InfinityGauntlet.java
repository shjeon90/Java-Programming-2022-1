
public class InfinityGauntlet {
	private PowerStone powerStone;
	private RealityStone realityStone;
	private TimeStone timeStone;
	private MindStone mindStone;
	private SoulStone soulStone;
	
	public InfinityGauntlet() {
		this.powerStone = null;
		this.realityStone = null;
		this.timeStone = null;
		this.mindStone = null;
		this.soulStone = null;
	}

	public InfinityGauntlet(PowerStone powerStone, RealityStone realityStone, TimeStone timeStone, MindStone mindStone,
			SoulStone soulStone) {
		this.powerStone = powerStone;
		this.realityStone = realityStone;
		this.timeStone = timeStone;
		this.mindStone = mindStone;
		this.soulStone = soulStone;
	}
	
	public PowerStone getPowerStone() {
		return powerStone;
	}

	public void setPowerStone(PowerStone powerStone) {
		System.out.println("attached the power stone.");
		this.powerStone = powerStone;
	}

	public RealityStone getRealityStone() {
		return realityStone;
	}

	public void setRealityStone(RealityStone realityStone) {
		System.out.println("attached the reality stone.");
		this.realityStone = realityStone;
	}

	public TimeStone getTimeStone() {
		return timeStone;
	}

	public void setTimeStone(TimeStone timeStone) {
		System.out.println("attached the time stone.");
		this.timeStone = timeStone;
	}

	public MindStone getMindStone() {
		return mindStone;
	}

	public void setMindStone(MindStone mindStone) {
		System.out.println("attached the mind stone.");
		this.mindStone = mindStone;
	}

	public SoulStone getSoulStone() {
		return soulStone;
	}

	public void setSoulStone(SoulStone soulStone) {
		System.out.println("attached the soul stone.");
		this.soulStone = soulStone;
	}

	public boolean isFullStones() {
		return this.powerStone != null && this.realityStone != null && this.timeStone != null && this.mindStone != null && this.soulStone != null;
	}
}
