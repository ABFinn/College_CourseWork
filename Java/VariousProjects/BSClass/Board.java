/**
 * The Board interface represents a collection of methods to be 
 * implmented by various types of game boards (BattleshipBoard, eg)
 * 
 * @author Chris Bennett
 * 
 * 
 */

public interface Board {


	//You should declare a 2D array of integers in your 
	//BattleshipBoard class that implements this interface

	/*
	 * Get the value of a particular (i,j) cell in the board.
	 * 
	 * @param i Value of the column 
	 * @param i Value of the row 
	 */
	public int getCell(int i, int j);
	/*
	 * Check to see if the board is in a winning state.
	 * 
	 * @return True if board is in winning state
	 */
	
	public boolean checkForWin();


	/*
	 * Populate board with appropriate values to begin game
	 * 
	 */
	public void initBoard(int x, int y);


}
