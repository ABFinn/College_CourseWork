public class Card {

	protected int rank;
	protected int suit;
	public static final int DIAMOND=1;
	public static final int CLUB=2;
	public static final int HEART=3;
	public static final int SPADE=4;


	//default constructor
	public Card() {
		//set rank to default value
      rank = 2;

		//set suit to default value
      suit = SPADE;

	}

	//constructor where rank and suit are passed in
	public Card(int r, int s) {
		//check to see if r and s are valid
		//  if they are, set rank/suit
		//  else set them to default values
      
      if(s >= 1 && s <= 4 && r >= 2 && r <= 14) {
         rank = r;
         suit = s;
      
      }
      else{
      rank = 2;
      suit = SPADE;
      
      }

	}


	public int getSuit() {
      return suit;
	}

	public int getRank() {
      return rank;
	}

	
	public void setRank(int r) {
      if(r >= 2 && r <=14){
         rank = r;
      }      
	}

	public void setSuit(int s) {
      if(s >= 1 && s <= 4){
         suit = s;
      }   
	}

	public String toString() {
		String s="";

		if (rank == 14) {
			s = s + "A";
		}
      else if (rank == 13) {
         s = s + "K";
      }
      else if (rank == 12) {
         s = s + "Q";
      }
      else if (rank == 11) {
        s = s + "J";
      }
      else{
        s = s + rank;     
      }

		
      if(suit == DIAMOND) {
			s += "D";
		}
      else if(suit == HEART) {
         s+= "H";
      }
      else if(suit == CLUB) {
         s+= "C";
      }
      else {
         s+= "S";
      }



		return s;
	}
	
	public int compareTo(Card c) {
      return rank - c.getRank();
      /*
		if(rank > c.getRank()) {
			return 1;
		}
		else if (rank < c.getRank()) {
			return -1;
		}
		else {
			return 0;
		}
      */
      
	}
   //Card c1 = new Card(2,3)
   //Card c2 = new Card(3,4)
   //c1.compareTo(c2) // = -1
   public static void main(String [] args) {
   Card c1 = new Card(2,4);
   Card c2 = new Card(14,3);
   
   System.out.println(c1);
   //Not necessary to type .toString, java will assume
   System.out.println(c2.toString());
   System.out.println(c1.compareTo(c2));
   
   }

}
