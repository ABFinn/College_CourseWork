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
   
   public Card checkForRank(int rank) {
      Card c = new Card(rank, 2);
      System.out.println("Card you're looking for: " + c.getRank());
      System.out.println(c.getRank());
      for(int i = 0;i < hand.size();i++){
         if(hand.get(i).getRank() == c.getRank()){
            return hand.get(i);
         
         }       
      }
      return c;
   
   }
   
   public boolean removePairs() {
      for(int i = 0; i <hand.size() - 1; i++){
         for(int j = i+1; j < hand.size(); j++){
            if(hand.get(i).getRank() == hand.get(j).getRank()){
               hand.remove(j);
               hand.remove(i);
               return true;
            
            }
         
         }
      
      }
      return false;
     
    }
      
      /*int check = 0;
      int points = 0;
      for(int i = 0; i< hand.size(); i++){
         if(hand.get(i).getRank() == rank){
               check++;
            }
               
      }
      if(check >= 2){
           for(int j = 0; j< hand.size(); j++){
               if(hand.get(j).getRank() == rank) {
                  hand.remove(j);
                  points++;
               }
              }
           }

      return points;
      */
   
   
   

	public boolean hasNext() {
		if(hand.size() == 0) {
			return false;
		}
		return true;
	}


	public int size() {
		return hand.size();
	}
   
      
   public String toString() {
      String s = "";
      
      for(int i =0;i<hand.size();i++) {
       s += hand.get(i) + " ";      
      }
      return s;
   
   }

}
