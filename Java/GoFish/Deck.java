import java.util.Random;

public class Deck {

	private Card [] deck;
	private int top;
	private static Random rdm = new Random();

	public Deck() {
		//instantiate Card array
      deck = new Card[52];

		//fill array with actual cards
      int i = 0;
      for(int r = 2;r<=14;r++){
         for(int s = 1;s<=4;s++){
            deck[i++] = new Card(r,s);
            
         }
      }
           
		//set "top" card index to 0
      top = 0;

	}



	public Card dealCard() {
		//take next card off of "top" of deck
		//  if there are no more cards left, shuffle
      Card t = deck[top];
		//adjust "top" index
      top++;
      
      if(top == deck.length) {
         shuffle();
         top = 0;     
      }
      return t;
	}

	public void shuffle() {
		//lots of ways to do this
		//what would you do?
      for(int i = 0;i<1000;i++){
         int a = rdm.nextInt(deck.length); //Gives a random number between 0 - 51, assigns it to a
         int b = rdm.nextInt(deck.length); // "" assigns it to b
         Card t = deck [a];
         deck [a] = deck [b];
         deck [b] = t;
         
      }


	}

	public String toString() {
		String str = "";
      for(int i = 0; i < deck.length;i++){
         str += deck[i].toString() + " ";
      }

		return str;

	}
   public static void main(String [] args) {
      Deck d = new Deck();
      System.out.println(d.toString());
      d.shuffle();
      System.out.println(d.toString());
   
   }

}
