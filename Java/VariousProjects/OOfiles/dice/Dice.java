import java.util.Random;

public class Dice {

    //instance variables
	private int numSides;
	private int face;
	private Random rdm;

	//CONSTRUCTOR
	public Dice(int sides) {
		rdm = new Random();
		numSides =  sides;
		roll();
	}


	//BEHAVIORS

	public int roll() {

		face = rdm.nextInt(numSides) + 1;

		return face;

	}



	//GETTER / SETTER METHODS

	public int getFace() {


		return face;

	}

}  //class Dice
