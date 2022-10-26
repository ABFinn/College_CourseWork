import java.util.Scanner;



public class Game {


	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Map m = new Map(5,5);
		String s;
		boolean wantsToExplore = true;
		int x,y;
		while(wantsToExplore) {
			System.out.println(m);

			System.out.print("Coordinates to explore: ");
			x = input.nextInt();
			y = input.nextInt();
			m.travel(x-1,y-1);

		}

	}


}
