


public class Grass implements MapSpace {

	private String name;

	public Grass() {
		name = "grass";
	}

	public void enter() {
		System.out.println("Green grow the rushes grow");
	}

	public void exit() {
		System.out.println("Somebody should mow this place");
	}

	public String toString() {
		return "G";
	}

}
