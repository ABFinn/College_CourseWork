import java.util.Random;

public class WordMaker {

	private static Random rdm = new Random();

	public static String makeRandomWord() {
		String s = "";
		int l = rdm.nextInt(8) + 3;
		for (int i=0;i<l;i++) {
			s += (char) ('a' + rdm.nextInt(26));
		}
		return s;		
	}

}
