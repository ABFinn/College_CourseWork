

public class DNode {

	protected String element;
	protected DNode next, prev;

	
	public DNode(String e, DNode p, DNode n) {
		element = e;
		next = n;
		prev = p;
	}

	public DNode(String e) {
		element = e;
		next = null;
		prev = null;
	}
	
	public String getElement() {

		return element;

	}

	public DNode getPrev() {

		return prev;

	}


	public DNode getNext() {

		return next;

	}


	public void setElement(String s) {
		element = s;
	}
	
	
	public void setPrev(DNode p) {
		
		prev = p;
		
	}
	
	
	public void setNext(DNode n) {
		
		next = n;
		
	}

	

}

