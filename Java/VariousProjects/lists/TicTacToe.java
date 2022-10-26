import java.util.Scanner;

public class TicTacToe {

	protected static final int X = 1, O = -1;
	protected static final int EMPTY = 0;
	protected int board[][] = new int[3][3];
	protected int player;

	public TicTacToe() {
		clearBoard();
	}
	
	public void clearBoard() {
		for (int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = EMPTY;
			} 
		}
		player = X;
	}		

	public void putMark(int i, int j) throws IllegalArgumentException {
		if (i<0 || i>2 || j<0 || j>2) {
			throw new IllegalArgumentException("Invalid board position");
		}
		if(board[i][j] != EMPTY) {
			throw new IllegalArgumentException("Board position occupied");
		}
		board[i][j] = player;
		player = player * -1;

	}


	public boolean isWin(int mark) {
		if (board[0][0] == mark && board[0][1]==mark && board[0][2]==mark) {
			return true;
		}
		if (board[1][0] == mark && board[1][1]==mark && board[1][2]==mark) {
			return true;
		}
		if (board[2][0] == mark && board[2][1]==mark && board[2][2]==mark) {
			return true;
		}

		
		if (board[0][0] == mark && board[1][0]==mark && board[2][0]==mark) {
			return true;
		}
		if (board[0][1] == mark && board[1][1]==mark && board[2][1]==mark) {
			return true;
		}
		if (board[0][2] == mark && board[1][2]==mark && board[2][2]==mark) {
			return true;
		}

		if (board[0][0] == mark && board[1][1]==mark && board[2][2]==mark) {
			return true;
		}

		if (board[2][0] == mark && board[1][1]==mark && board[0][2]==mark) {
			return true;
		}

		return false;
		
	}

	public int winner() {
		
		if(isWin(X)) {
			return X;
		}
		else if (isWin(O)) {
			return O;
		}
		return 0;
	}

	public String toString() {
		String s="";
		for (int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {		
				switch(board[i][j]) {
					case X: s += "X";break;
					case O: s += "O";break;
					case EMPTY: s += " ";break; 
				}
				if (j<2) {
					s += "|";
				}
			}
			if (i < 2) {
				s += "\n-----\n";
			}
		}
		return s;
	}

	public static void main(String [] args) {
		TicTacToe game = new TicTacToe();
		Scanner input = new Scanner(System.in);
		int x, y;
		int player = X;
		
		while(!game.isWin(player)) {
			System.out.println(game.toString());
			System.out.println("Next move (x y): ");
			x = input.nextInt();
			y = input.nextInt();
 			
			game.putMark(x,y);
	
		} 
		System.out.println(game.winner() + " wins");
	
	}
}


