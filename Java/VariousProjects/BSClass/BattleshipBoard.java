import java.util.Random;


public class BattleshipBoard implements Board {
   //declare instance variables
  
   protected int board[][]; 
   int sea = 0;
   int ship = 1;
   int miss = 2;
   int hit = 3; 
   private static Random rdm = new Random();
   
   //define constuctors(s)
   
   //define other methods
   
   //define methods declared in Board
   
   public BattleshipBoard() {
      initBoard(15,15);   
    
   }
   
   public void initBoard(int x, int y){       
   board = new int[x][y];
   int r1 = rdm.nextInt(x);
   int r2 = rdm.nextInt(y);
       
      for(int i = 0; i < x; i ++){
         for(int j = 0; j < y; j++){
            board[i][j] = sea;
         
         
         }
      }
      
      /*
      
      for(int i = 0; i < 5; i ++){
         for(int j = 0; j < 1; j++){
            board[r1][r2] = ship;
            r1++;
         
         
         }
      }
      
      */
      
      
      
      
      
   
   }
   
   
   public boolean checkForWin(){
   
      return false;
   }
   
   
   public int getCell(int x, int y){
   
      return board[x][y];
   }


   public void makeMove(int x, int y) {
         
   
      }
   
   public String toString() {
      String s = "";
      return s;
      }
   
   public String showSolution() {
      String s = "";
      return s;
      
      }
      
    public static void main(String [] args) {
      
      BattleshipBoard board = new BattleshipBoard();
      
    }
}