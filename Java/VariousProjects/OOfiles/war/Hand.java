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
   
   public Card getCard(int i){
   if(i >= 0 && i < hand.size()){
      return hand.remove(i);
   
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
   
   public void clear(){
      hand.clear();
   
   }

   
	public int size() {
		return hand.size();
	}


}
