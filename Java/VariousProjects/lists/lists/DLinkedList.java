

public class DLinkedList {

	protected DNode head;
	protected DNode tail;
	protected int size;

	public DLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(String s) {

		//create a new node storing s
		DNode n = new DNode(s);
		
		//if we're adding it to front, where should
		//n's next point?
		n.setNext(head);
      if(size > 0){
         head.setPrev(n);
      }

		//is there a new head?
      head = n;
      //n.getNext().setPrev(n);


		//special cases? does tail change?
      if(size == 0){
         tail = n;      
      }

		
		
		//need to adjust the size?
      size++;


	} 

	public void addLast(String s) {
		//special case -- if nothing is in list, 
		//we can just call addFirst, passing s
		//why?
		if(size==0) {
			this.addFirst(s);
		}
	
		else {
			//create new node
			DNode n = new DNode(s);	
			//n is new end so its previous must be tail
			n.setPrev(tail);
			
			//old tail's next must now point to n			
			tail.setNext(n);
			
			//we have a new tail!
			tail = n;
			
			//adjust size
			size++;
		}
	}

	public void removeFirst() {

		//first case -- more than 1 element in list already
		//why is this a special case?
		//why might we test for it first rather than test for == 1?
		if(size>1) {
			//assign head to second element of list
			head = head.getNext();
			//assign this new head's previous to null
			//why?
         head.getPrev().setNext(null);
			head.setPrev(null);		
			
			//adjust size
			size--;

		}		
		//1 element in list
		else if(size==1){
			//null everything out -- why?
			head = null;
         tail = null;
			
			//adjust size
			size = 0;
		}
		//no case for size==0 -- why? is this okay?

	}


	public void removeLast() {
		//case for if size > 1
		if(size>1) {
			//set tail to second to last element
			tail = tail.getPrev();
			
			//set new tail's next to null
         tail.getNext().setPrev(null);
			tail.setNext(null);
         
			
			//adjust size
			size--;
		}		
		else if (size==1) {
			//null everything out
			head = null;
         tail = null;

			//adjust size
			size = 0;
		}

	}

	public void addAt(int n, String s) {
		//special case -- list is empty 
		if(n==0) {
			//what have we already written that would work here?
			addFirst(s);
		}
		//special case -- want to add at end
		else if(n==size-1) {
			//what have we already written that would work here?
			addLast(s);		}
		//want to add in middle somewhere
		else {
			DNode node = new DNode(s);
	
			//figure out whether to start at end or beginning
			if(size/2 < n) {
				//because the middle is to the left of n
				//we're going to start at the end

				//creata a temp node pointing at tail
				//we'll use this is a placeholder for iterating
				//backward through the list
				DNode temp = tail;		

				//now we need a loop whose counter starts at the end
				//and works back to n
            //1 2 3 4 5
            //  3, 7
            //  4 = 7
            // 1 2 3 7 4 5
				for(int i = size ; i > n; i--) {
					//move the placeholder to its previous
					temp = temp.getPrev();
				}
				//so now we have node (what we want to insert)
				//and temp (placeholder for where we want to insert it)
				//so we need to splice node into temp's position

				//set temp's next's previous to node 
				temp.getNext().setPrev(node);

				//set node's next to temp's next
				node.setNext(temp.getNext());

				//set node's previous to temp
				node.setPrev(temp);

				//set temp's next to node
				temp.setNext(node);

			}
			else {
				//start at beginning
				DNode temp = head;		
				//where should this loop stop?
            //1 2 3 4 5
            //  1, 7
            //  2 = 7
            // 1 7 2 3 4 5
				for(int i=0;i < n - 1;i++) {
					//move placeholder forward
					temp = temp.getNext();
				}
				//set temp's next's previous to node 
				temp.getNext().setPrev(node);

				//set node's next to temp's next
				node.setNext(temp.getNext());

				//set node's previous to temp
				node.setPrev(temp);

				//set temp's next to node
				temp.setNext(node);
			}
			
			//adjust size
			size++;
		}
	}

	public void removeAt(int n) {
		//special case -- want to remove first element
		if(n==0) {
			removeFirst();
		}
		//special case -- want to remove last element
		else if(n==size-1) {
			removeLast();
		}
		else {
			//figure out whether to start at end or beginning
			if(size/2 < n) {
				//start at end
				DNode temp = tail;		
				for(int i=size;i>n;i--) {
					temp = temp.getPrev();
				}
				//create node t to point at temp's next
				DNode t = temp.getNext();
				
				//set temp's next to temp's next's next
				temp.setNext(temp.getNext().getNext());
				
				//set temp's next's previous to temp
				temp.getNext().setPrev(temp);
				
				//set t's next and previous to null -- why?
				t.setNext(null);
				t.setPrev(null);
			}
			else {
				//start at beginning
				DNode temp = head;		
				for(int i=0;i<n-1;i++) {
					temp = temp.getNext();
				}
				//create node t to point at temp's next
				DNode t = temp.getNext();
				
				//set temp's next to temp's next's next
				temp.setNext(temp.getNext().getNext());
				
				//set temp's next's previous to temp
				temp.getNext().setPrev(temp);
				
				//set t's next and previous to null -- why?
				t.setNext(null);
				t.setPrev(null);
			}
			
			//adjust size -- why is this inside the else?
			size--;
		}
	}

	public String elementAt(int n) {
			if(size/2 < n) {
				//start at end
				DNode temp = tail;		
				for(int i=size;i>n;i--) {
					temp = temp.getPrev();
				}
				return temp.getElement();
			}
			else {
				//start at beginning
				DNode temp = head;		
				for(int i=0;i<n-1;i++) {
					temp = temp.getNext();
				}
				return temp.getElement();
			}
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
       return size == 0;
	}

	public String toString() {
		String s = "[";
		DNode temp = head;		
		
		//iterative over list, adding each node's
		//contents to String s.  Add a comma after 
		//each element as long as it's not last element
		for(int i=0;i<size;i++) {
			s += temp.getElement();
			if(i<size-1) { 
				s+=",";
			}
			temp = temp.getNext();
		}
		return s + "]";
	}

}
