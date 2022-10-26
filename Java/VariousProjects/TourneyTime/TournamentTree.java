

public class TournamentTree <E> extends LinkedBinaryTree <E> {



   public void playGames(Position <E> node) {
      
      //extract the game from the node parameter
      Game g = (Game) node.getElement();

      //base case
      //if no left child, then this must be a leaf. 
      //Set winner of game to the game's player1 
      if(left(node) == null){
         g.setWinner(g.getPlayer1());
         return;
      }

      //second base case
      //if there is already a winner, return
      else if(g.getWinner() != null){
         return;
      }


      //recursive cases      
      //call playGames on left child of node
      playGames(left(node));

      //call playGames on right child of node
      playGames(right(node));

      
      //Do not need to change the rest      
      Game left = (Game) left(node).getElement();
      Game right = (Game) right(node).getElement();
      g.setPlayer1(left.getWinner());
      g.setPlayer2(right.getWinner());
      g.play();           
      
   }




}