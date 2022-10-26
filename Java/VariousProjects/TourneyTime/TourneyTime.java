import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class TourneyTime {

   public static void main(String [] args) {
   
      TournamentTree <Game> bracket = new TournamentTree <Game> ();
      ArrayList <Player> teams = new ArrayList <Player>();
      
      Scanner keyboard = new Scanner(System.in);
      Scanner bracketFile = null;
      Scanner teamsFile=null;

      try {
         teamsFile = new Scanner(new File("teams.txt"));
         bracketFile = new Scanner(new File("brackets.txt"));
      }
      catch(Exception e) {
         System.out.println("Files not found. Goodbye!");
         System.exit(0);
      } 
      //load the files
      loadTeams(teams, teamsFile);
      bracket = loadBracket(teams, bracketFile);
      
      for(Game n : bracket) {
         System.out.println(n);
      }

      System.out.println(" --- Games Starting! --- ");
      System.out.println("Hit enter to start...");
      keyboard.nextLine();
      
      bracket.playGames(bracket.root());

      System.out.println(" --- Games Over! --- ");
      
      int size=bracket.size();
      int height = bracket.height(bracket.root());
      
      for(Game n : bracket) {
         int round = n.getRound();
         System.out.print("R" + round);
         for(int i=0;i<round+1;i++) {
            System.out.print("   ");
         }
         System.out.println(n);
      }
      

   }
   
   public static void loadTeams(ArrayList <Player> teams, Scanner teamsFile) {
      while(teamsFile.hasNext()) {
         String line = teamsFile.nextLine();
         Scanner team = new Scanner(line);
         team.useDelimiter(",");
         String name = team.next();
         int wins = team.nextInt();
         int losses = team.nextInt();
         int ppg = team.nextInt();
          
         Player p = new Player(name, wins, losses, ppg);
         teams.add(p);
      }   
   
   }
   
   public static TournamentTree <Game> loadBracket( ArrayList <Player> teams, Scanner bracketFile) {
      ArrayList <TournamentTree <Game>> games = new ArrayList <TournamentTree <Game>>();
      
      for(Player p : teams) {
         TournamentTree <Game> t = new TournamentTree <Game> ();
         t.addRoot(new Game(p,null,0)); 
         games.add(t);
      }      
      while(games.size() > 1) {
         TournamentTree <Game> team1 = games.remove(0);
         TournamentTree <Game> team2 = games.remove(0);
         TournamentTree <Game> game = new TournamentTree <Game> ();
         game.addRoot(new Game(new Player("unplayed"),null,team1.root().getElement().getRound() + 1));
         game.attach(game.root(),team1,team2);
         games.add(game);
      }
      return games.get(0);
   }
   
   public static void playGames(LinkedBinaryTree <Game> bracket) {
   
      Position <Game> root = bracket.root();
      
      
   
   }

}