

public class Sand implements MapSpace {

	private String name;

	public Sand() {
		name = "sand";
	}

	public void enter() {
		System.out.println("Hard to walk in this area");
	}

	public void exit() {
		System.out.println("Bye bye beach");
	}

	public String toString() {
		return "S";
	}
}
