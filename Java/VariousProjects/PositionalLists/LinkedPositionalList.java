

public class LinkedPositionalList <E> implements PositionalList <E> {
	

	private static class Node <E> implements Position <E> {
		private E element;
		private Node <E> prev;
		private Node <E> next;

		public Node(E e, Node <E> p, Node <E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if(next==null){
				throw new IllegalStateException("Illegal State!");
			}
			return element;
		}
		public Node <E> getPrev() {
			return prev;
		}
		public Node <E> getNext() {
			return next;
		}
		public void setElement(E e) {
			element = e;
		}
		public void setNext(Node <E> n) {
			next = n;
		}
		public void setPrev(Node <E> p) {
			prev = p;
		}

	} //inner class Node

	//instance variables for LinkedPositionalList
	private Node <E> header;
	private Node <E> trailer;
	private int size;

	public LinkedPositionalList() {
		header = new Node <> (null,null,null);
		trailer = new Node <> (null, null, null);
		size=0;
	}

	private Node <E> validate(Position <E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid position");
		}
		Node <E> node = (Node <E>) p;
		if(node.getNext() == null) {
			throw new IllegalArgumentException("Not a valid position");
		}
		return node;
	}

	private Position <E> position(Node <E> node) {
		if(node == header || node == trailer){
			return null;	
		}
		return node;
	}

	public int size() {
      return size;
	}

	public boolean isEmpty() {
      return size == 0;
	}


	public Position <E> first() {
		//return next of header
      return header.getNext();
	}

	public Position <E> last() {
		//return prev of trailer
      return trailer.getPrev();
	}

	public Position <E> before(Position <E> p) throws IllegalArgumentException {
		//create node with validate() method - this may throw an exception
      Node <E> node = validate(p);
		//return the position of the node's prev
      return node.getPrev();
	}

	public Position <E> after(Position <E> p) throws IllegalArgumentException {
		//create node with validate() method - this may throw an exception
      Node <E> node = validate(p);
		//return the position of the node's next
		return node.getNext();
	}


	private Position <E> addBetween(E e, Node <E> pred, Node <E> succ) {
		//create a new Node based on e, pred, succ
      Node <E> newNode = new Node(e,pred,succ);
		//set pred's next to the new node
      pred.setNext(newNode);
		//set succ's prev to the new node
      if(size == 0) {
         trailer.setPrev(newNode);
         newNode.setNext(trailer);
      }
      else{
         succ.setPrev(newNode);
      }
		//increment size
      size++;
		//return the new node
	   return newNode;
	}

	public Position <E> addFirst(E e) {
		//call addBetween, passing e, the header, header's next
      return addBetween(e, header, header.getNext());
		//return what addBetween() returns
   
	}

	public Position <E> addLast(E e) {
		//call addBetween, passing e, trailer's prev, trailer
      return addBetween(e, trailer.getPrev(), trailer);
		//return what addBetween() returns

	}

	public Position <E> addBefore(Position <E> p, E e) throws IllegalArgumentException {
		//get Node in p using validate
      Node <E> node = validate(p);
		//call addBetween, passing e, node's prev, and node
      return addBetween(e, node.getPrev(), node);
      
	}

	public Position <E> addAfter(Position <E> p, E e) throws IllegalArgumentException {
		//get Node in p using validate
      Node <E> node = validate(p);

		//call addBetween, passing e, node, and node's next
      return addBetween(e, node, node.getNext());
	}

	public E set(Position <E> p, E e) throws IllegalArgumentException {
		//validate p, storing it in a Node variable
      Node <E> node = validate(p);
		//Create a variable to store the data of the node using getElement()
      E oldData = node.getElement();
		//change the node's value to e with setElement
      node.setElement(e);
		//return the old value
      return oldData;
	}

	public E remove(Position <E> p) throws IllegalArgumentException {
		//validate p, storing it in a Node variable
      Node <E> node = validate(p);
      
		//store the node's predecessor in a Node variable
      Node <E> prev = node.getPrev();
		//store the node's successor in a Node variable
      Node <E> next = node.getNext();
		//change predecessor's next to successor and vice versa
      prev.setNext(next);
      next.setPrev(prev);
		//decrement the size
      size--;
		//extract the data element from the node, storing it in a variable of type E
      E oldData = node.getElement();
		//null out the node's element, next, and prev
      node.setElement(null);
      node.setNext(null);
      node.setPrev(null);
		//return the data
      return oldData;
	}

}