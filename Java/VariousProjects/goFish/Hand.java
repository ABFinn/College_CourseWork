import java.util.ArrayList;


public class Hand {


	private ArrayList <Card> hand;


	public Hand() {
		hand = new ArrayList<Card>();
	} 


	public void addCard(Card c) {
		hand.add(c);		
	}



	public Card getNextCard() {
		if (hand.size() > 0) {
			return hand.remove(0);		
		}		
		else {
			return null;
		}
	}
   public Card seeHand(int i) {
      if (hand.size() > 0){
         return hand.get(i);
      }
      else {
         return null;
      }
   
   }

	public boolean hasNext() {
		if(hand.size() == 0) {
			return false;
		}
		return true;
	}


	public int size() {
		return hand.size();
	}
   
   public Card checkForRank(int rank) {
      Card c = new Card(rank, 3); 
      System.out.println(c.toString());
      
      for(int i = 0; i < hand.size(); i++){
         if(hand.remove(i) == c){
            c = hand.remove(i);
         }
         else return null;
      
      }
      return c;

   }
   
   public String toString() {
      String s = "";
      
      for(int i =0;i<hand.size();i++) {
       s += hand.get(i) + " ";      
      }
      return s;
   
   }

}
