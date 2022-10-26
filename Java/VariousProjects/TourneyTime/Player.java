import java.util.Random;

public class Player {

   protected static Random rdm = new Random();
   
   protected String name;
   //add other instance variables to determine "power"
   //these are example variables for a basketball team,
   //but you can change them to any attributes you'd like
   protected int wins;
   protected int losses;
   protected int ppg;
   /*
   protected double gir;
   protected double puttingAvg;
   */
   
   public Player(String n) {
      name = n;      
   }
   public Player(String n, int w, int l, int p) {
      name = n;
      wins = w;
      losses = l;
      ppg = p;
   
   }
   
   public String getName() {
      return name;
   }
   
   /*
   This subtracts losses from wins, adding points per game to get a team's "power".
   Your power function will be based on the attributes you choose for your type of team.
   */
   public double getPower() {
      return wins-losses+ Math.sqrt(ppg) +rdm.nextGaussian()*2; 
   }

   public String toString() {
      return name + ": W-" + wins + "- L-" + losses + " , " + ppg + " ppg";
   }

}