


public class Node {

	private String element;
	private Node next;


	public Node(String e, Node n) {
		element = e;
		next = n;
	}
	public Node(String e) {
		element = e;
		next = null;
	}

	public String getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

	public void setElement(String e) {
		element = e;
	}

	public void setNext(Node n) {
		next = n;
	}
   
   public static void main(String [] args) {
      Node n1 = new Node("the");
      Node n2 = new Node("big");
      Node n3 = new Node("apple");
      
      System.out.println(n1.getElement());
      System.out.println(n1.getNext());
      
      n1.setNext(n2);
      System.out.println(n1.getNext().getElement());
      
      n2.setNext(n3);
      
      System.out.println(n1.getNext().getNext().getElement());
      
   }
	
}
