import java.util.Random;

public class Deck {

	private Card [] deck;
	private int top;
	private static Random rdm = new Random();

	public Deck() {
		//instantiate Card array
		deck = new Card[52];

		//fill array with actual cards
		for(int rank=2 ; rank<15 ; rank++) {
			for(int suit=1;suit<5;suit++) {
				deck[(rank-2)*4 + suit-1] = new Card(rank,suit);
			}
		}

		//set "top" card index to 0
		top=0;

	}


	public Card dealCard() {
		//take next card off of "top" of deck
		//  if there are no more cards left, shuffle

		/*if (top==deck.length) {
			top=0;
			shuffle();
		}
      */
		Card temp = deck[top];		
		//adjust "top" index
		top++;
		return temp;
	}

	public void shuffle() {
		//lots of ways to do this
		//what would you do?
		Card temp;
		int numSwaps = deck.length;
		int c1,c2;
		
		for(int i=0;i<numSwaps;i++) {
			c1 = rdm.nextInt(deck.length);
			c2 = rdm.nextInt(deck.length);
			temp = deck[c1];
			deck[c1] = deck[c2];
			deck[c2] = temp;
		}	
		

	}

	public String toString() {
		String str = "";
		
		for (int i=top;i<deck.length;i++) {
			str = str + deck[i].toString() + " ";
		}
		return str;

	}

	public static void main(String [] args) {
		Deck d = new Deck();
		
		System.out.println(d.toString());
		
		d.shuffle();
		
		System.out.println(d.toString());
		
		System.out.println(d.dealCard());
		
		System.out.println(d.toString());
		
	
	}


}
