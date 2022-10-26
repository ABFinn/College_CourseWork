
public class Game {

   protected Player player1;
   protected Player player2;
   protected Player winner;
   protected Player loser;
   protected int round;
   double score;
   
   public Game(Player p1, Player p2,int r) {
      player1=p1;
      player2=p2;
      round = r;
   }
   
   public void play() {
      winner = player1;
      loser = player2;
      
      double result = player1.getPower() - player2.getPower() ;
      if(result < 0) {
         winner = player2;
         loser = player1;
      }
      score = result;
   }
   
   public String toString() {
      if(round==0) {
         return player1.toString();
      }
      else if(player1.getName().equals("unplayed")) {
         return "Round " + round + " Game"; 
      }
      String s = " - Round " + round + " Game -\n";
      s = player1.getName().toString() + " vs. " + player2.getName().toString() ;
      if(winner != null) {
         s += " , W: " + winner.getName();
      }
      return s;
   }
   
   public boolean played() {
      return winner != null;
   }
   
   public void setWinner(Player p) {
      winner = p;
   }
   
   public Player getPlayer1() {
      return player1;
   }
   public Player getPlayer2() {
      return player2;
   }
   public Player getWinner() {
      return winner;
   }
   
   public int getRound(){
      return round;
   }
   public double getScore() {
      return score;
   }
   public void setPlayer1(Player p) {
      player1 = p;
   }
   public void setPlayer2(Player p) {
      player2 = p;
   }
   
}