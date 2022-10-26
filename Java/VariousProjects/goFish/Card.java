
public class Card {

	protected int rank;
	protected int suit;
	public static final int DIAMOND=1;
	public static final int CLUB=2;
	public static final int HEART=3;
	public static final int SPADE=4;
	private String [] ranks ={"","","2","3","4","5","6","7","8","9","10","J","Q","K","A"}; 
	private String [] suits ={"","D","C","H","S"};

	//default constructor
	public Card() {
		//set rank to default value
		rank = 2;

		//set suit to default value
		suit = DIAMOND;

	}

	//constructor where rank and suit are passed in
	public Card(int r, int s) {
		//check to see if r and s are valid
		//  if they are, set rank/suit
		//  else set them to default values
		this();
		if (r > 1 && r < 15 && s>0 && s<5) {
			rank = r;
			suit = s;
		}
	}


	public int getSuit() {

		return suit;
	}

	public int getRank() {

		return rank;

	}

	
	public void setRank(int r) {		
		rank = r;
	}

	public void setSuit(int s) {
		suit = s;
	}

	public String toString() {
		String s="";

		s = s + ranks[rank];
		s += suits[suit];
		
		return s;
	}
	
	public int compareTo(Card c) {

		return rank - c.getRank();
		
	}


	public static void main(String [] args) {
	
		Card c1 = new Card();
		Card c2 = new Card();
		Card c3 = new Card(14,Card.SPADE);
		
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		//System.out.println(c3.toString());
      
 

		//System.out.println(c1.compareTo(c2));
		//System.out.println(c3.compareTo(c2));
		

	} //end main()

} //end Card class
