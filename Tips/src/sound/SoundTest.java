package sound;

public class SoundTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sound test = new Sound("S1.wav");
		test.play();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
