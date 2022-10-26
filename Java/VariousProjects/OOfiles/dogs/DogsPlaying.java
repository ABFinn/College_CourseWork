public class DogsPlaying {

	public static void main(String [] args) {
		Dog d1 = new Dog("fido", 40, "pitbull",false,true);
		Dog d2 = new Dog("tbone", 100, "doberman", true, false);
		Dog d3 = new Dog("bigboy", 100, "mixed", true, false);

		String s = new String("the big apple");

		//System.out.println(d1.speak());
		//System.out.println(d2.speak());
		
		d3.play(d2);
		d3.eat(1.0);
		d3.play(d2);
		d3.goPotty(4.0);
		d3.play(d2);

	}

}
