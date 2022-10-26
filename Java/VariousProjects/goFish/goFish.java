import java.util.Scanner;
import java.util.ArrayList;


public class goFish {

   /*Methods to add for Go Fish
   Input/Output/Process
   
   - Check for card w/ rank of x
      checkForCard
      input: int rank
      output: Remove Card  c/ Null if no
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
   
   intGetHandValue
      int value = 0;
      iterate over hand
      for each card
         add rank to value
         if(rnak <= 10)
            value += rank
         else if(rank > 10 ** rank < 14)
            value += 10
         return value;

   
   
   */
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		Deck deck = new Deck();
      String test = "";

		String userInput = "";
		boolean gameOver = false;
		boolean warOn = false;

		//printWelcome();

		//input.nextLine();

		//shuffle the deck
		deck.shuffle();
		//deal out hands
		for (int i=0;i<20;i++) {
			hand1.addCard(deck.dealCard());
			hand2.addCard(deck.dealCard());
		}
      //System.out.println(deck.toString() + "\n");
      System.out.println("Your hand: "  + hand1.toString());
      System.out.println(hand1.checkForRank(4));
           //System.out.println(Arrays.toString(hand1));
		//play game
		//while(!gameOver) {
			//get next cards from users
			


			
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
