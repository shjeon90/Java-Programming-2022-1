
public class PowerStone {
	private static final PowerStone powerStone = new PowerStone();
	
	public PowerStone() {
		
	}
	
	public static PowerStone getInstance() {
		return powerStone;
	}
}
