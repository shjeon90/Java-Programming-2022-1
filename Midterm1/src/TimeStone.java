
public class TimeStone {
	private static final TimeStone timeStone = new TimeStone();
	
	public TimeStone() {
		
	}
	
	public static TimeStone getInstance() {
		return timeStone;
	}
}
