package ExceptionHandling;


public class SpeedCheck {
	private static final int MIN_SPEED;
	private static final int MAX_SPEED;
	static {
		MAX_SPEED = 80;
		MIN_SPEED = 30;
	}
	
	public static void process(int speed) throws SpeedException {
		
		if(speed<=MIN_SPEED) {
			throw new SpeedException("You're going too slow ,you turtle!! Causing Traffic");
		}
		if (speed>MAX_SPEED) {
			throw new SpeedException("Drive slow, You're not Max Verstappen!!");
		}
	}
	
}
