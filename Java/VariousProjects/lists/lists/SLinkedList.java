
public class SLinkedList {

	protected Node head, tail;
	protected int size;


	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public SLinkedList(String s) {
		head = new Node(s);
		tail = head;
		size = 1;
	}
	public SLinkedList(Node n) {
		head = n;
		tail = head;
		size = 1;
	}


	public void addFirst(String s) {		
		Node n = new Node(s);
		n.setNext(head);
		head = n;
		if(size==0) {
			tail = head;
		}
		size++;
	} 


	public void addLast(String s) {
		if(size==0) {
			addFirst(s);
		}
		else {
			Node n = new Node(s);
			tail.setNext(n);
			tail=n;
			tail.setNext(null);
			if(size==0) {
				head=tail;
			}
			size++;
		}
	}

	public void removeFirst() {
		if(head != null){
         head = head.getNext();		
		   size--;
      }
	}

	public void removeLast() {
		Node temp = head;		
		for(int i=0;i<size-2;i++) {
			temp = temp.getNext();
		}
		tail = temp;
		tail.setNext(null);
		size--;
	}

	public void addAt(int n, String s) {

		if(n==0) {
			addFirst(s);
		}
		else if(n==size-1) {
			addLast(s);
		}
		else {
			Node node = new Node(s);
			Node temp = head;		
			for(int i=0;i<n-1;i++) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			size++;
		}
	}

	public void removeAt(int n) {

		if(n==0) {
			removeFirst();
		}
		else if(n==size-1) {
			removeLast();
		}
		else {
			Node temp = head;		
			for(int i=0;i<n-1;i++) {
				temp = temp.getNext();
			}
            //Node toRemove = temp.getNext();
			temp.setNext(temp.getNext().getNext());
            //toRemove.setNext(null);
			size--;
		}
	}

	public String elementAt(int n) {
		Node temp = head;		
		for(int i=0;i<n;i++) {
			temp = temp.getNext();
		}
		return temp.getElement();
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public String toString() {
		String s = "[";
		Node temp = head;		
		for(int i=0;i<size;i++) {
			s += temp.getElement();
			if(i<size-1) { s+=",";}
			temp = temp.getNext();
		}
		return s + "]";
	}

	public static void main(String [] args) {
		SLinkedList list = new SLinkedList();
		list.addFirst("first");
		list.addLast("second");
		list.addLast("third");
		System.out.println(list.toString());
		
		list.addAt(1,"newsecond");
		System.out.println(list.toString());

		list.removeAt(1);
		System.out.println(list.toString());

		list.removeAt(0);
		System.out.println(list.toString());



	}

}
