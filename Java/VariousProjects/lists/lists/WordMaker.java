import java.util.Random;

public class WordMaker {

	private static Random rdm = new Random();

	public static String makeRandomWord() {
		String s = "";
		int len = rdm.nextInt(8) + 3; //returns 3-10
		for (int i=0;i<len;i++) {
			s += (char) ('a' + rdm.nextInt(26));
		}
		return s;		
	}

}
