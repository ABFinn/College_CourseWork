import java.util.Scanner;
import java.util.ArrayList;


public class goFish {

   /*Methods to add for Go Fish
   Input/Output/Process
   
   - Check for card w/ rank of x
      checkForCard
      input: int rank
      output: Remove Card  c   / Null if no
      process: 
         go through hand looking for card w/ rank
         if found, remove from hand and return it
         
         if you look through all the cards and don't find it, return null
   
   - Remove all pairs from a hand
      removePairs()
      input: 
      output: 
      process:
      
      
   - Ask user for what card to check for
   - Translate that string into a rank
   - Call checkForCard(rank)
   - if that returns not null, add the card to h1
   - else go fish ( take a card from deck)
   - call removePairs()
   
   
   
   */
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		Deck deck = new Deck();
      String test = "";
      int p1pairs = 0;
      int p2pairs = 0;

		String userInput = "";
		boolean gameOver = false;
      
      
		//printWelcome();

		//input.nextLine();

		//shuffle the deck
		deck.shuffle();
		//deal out hands
		for (int i=0;i<10;i++) {
			hand1.addCard(deck.dealCard());
			hand2.addCard(deck.dealCard());
		}
      
      
      
            
      
      System.out.println("Your hand: "  + hand1.toString());
      System.out.println("Their hand: "  + hand2.toString());
      
      if(hand1.removePairs()){
         p1pairs++;
         if(hand1.removePairs()){
            p1pairs++;
            if(hand1.removePairs()){
               p1pairs++;
            }

         }
      }
      if(hand2.removePairs()){
         p2pairs++;
         if(hand2.removePairs()){
            p2pairs++;
            if(hand2.removePairs()){
               p2pairs++;
            }

         }
      }
            
      System.out.println("P1 Pairs: " + p1pairs);
      System.out.println("P2 Pairs: " + p2pairs);
      
      System.out.println("Your new hand: "  + hand1.toString());
      System.out.println("Their new hand: "  + hand2.toString());


      
      

      
      //User Input
      /*
      System.out.println("Enter a Rank");

      String userRankS = input.nextLine();  // Read user input
      System.out.println("You asked for a: " + userRankS);  // Output user input
      
      int userRank = Integer.parseInt(userRankS);
      
      System.out.println("Result of checkForRank: " + hand2.checkForRank(userRank));
      */


      //System.out.println(deck.toString() + "\n");
      
 
           //System.out.println(Arrays.toString(hand1));
		//play game
		//while(!gameOver) {
			//get next cards from users

      //System.out.println("Result of checkForRank: " + hand1.checkForRank(12));
      
      
      //System.out.println(hand1.removePairs(12));
      //System.out.println("Your new hand: "  + hand1.toString());
      
			
	   //}
   
 }

	public static void printWelcome() {

		System.out.println("\n\nWelcome to the card game War.  Each player gets");		
		System.out.println("half of the deck, and each throws out his/her next");		
		System.out.println("card.  The high card takes both cards, and the game");		
		System.out.println("is over when someone has all of the cards.  In the");		
		System.out.println("case of a tie, we will each put face down three");		
		System.out.println("additional cards then throw out a card face up.  High ");		
		System.out.println("card gets all the card on the table.  Ready to play?");		
		System.out.println("\nHit enter...");		

	}

}
