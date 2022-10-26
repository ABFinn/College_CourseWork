

public class DiceGame {


	public static void main(String [] args) {
		
		Dice d = new Dice(6);
		Dice d2 = new Dice(6);
      
      
      for(int i=0;i<100;i++){
         System.out.println(d.roll() + d2.roll());
      
      }
      
      /*
		System.out.println(d.roll());
		System.out.println(d2.roll());
		System.out.println(d.roll());
		System.out.println(d2.roll());
      */

	}


}
