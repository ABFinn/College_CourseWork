

public class Water implements MapSpace {

	private String name;


	public Water() {
		name = "water";
	}
	public void enter() {
		System.out.println("Hope you can swim");
	}

	public void exit() {
		System.out.println("That was a refreshing dip");
	}
	public String toString() {
		return "W";
	}

}
