

public class DLinkedList {

	protected _______ head;
	protected _______ tail;
	protected int size;

	public DLinkedList() {
		head = _____________________;
		tail = _____________________;
		size = ______;
	}

	public void addFirst(String s) {

		//create a new node storing s
		DNode n = ______________;
		
		//if we're adding it to front, where should
		//n's next point?
		n.setNext(_______);

		//is there a new head?


		//special cases? does tail change?		
		
		
		//need to adjust the size?


	} 

	public void addLast(String s) {
		//special case -- if nothing is in list, 
		//we can just call addFirst, passing s
		//why?
		if(size==0) {
			______________;
		}
	
		else {
			//create new node
			DNode n = _______________;	
			//n is new end so its previous must be tail
			__________________;
			
			//old tail's next must now point to n			
			__________________;
			
			//we have a new tail!
			__________________;
			
			//adjust size
			__________________;
		}
	}

	public void removeFirst() {

		//first case -- more than 1 element in list already
		//why is this a special case?
		//why might we test for it first rather than test for == 1?
		if(size>1) {
			//assign head to second element of list
			head = _____________;
			//assign this new head's previous to null
			//why?
			__________________;		
			
			//adjust size
			__________________;

		}		
		//1 element in list
		else if(size==1){
			//null everything out -- why?
			__________________;
			
			//adjust size
			__________________;
		}
		//no case for size==0 -- why? is this okay?

	}


	public void removeLast() {
		//case for if size > 1
		if(size>1) {
			//set tail to second to last element
			tail = __________________;
			
			//set new tail's next to null
			__________________;
			
			//adjust size
			__________________;
		}		
		else if (size==1) {
			//null everything out
			__________________;

			//adjust size
			__________________;
		}

	}

	public void addAt(int n, String s) {
		//special case -- list is empty 
		if(n==0) {
			//what have we already written that would work here?
			________________;
		}
		//special case -- want to add at end
		else if(n==size-1) {
			//what have we already written that would work here?
			________________;		}
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
				DNode temp = ________;		

				//now we need a loop whose counter starts at the end
				//and works back to n
				for(int i=_______; i > _____; ____) {
					//move the placeholder to its previous
					temp = ___________;
				}
				//so now we have node (what we want to insert)
				//and temp (placeholder for where we want to insert it)
				//so we need to splice node into temp's position

				//set temp's next's previous to node 
				________________;

				//set node's next to temp's next
				________________;

				//set node's previous to temp
				________________;

				//set temp's next to node
				________________;

			}
			else {
				//start at beginning
				DNode temp = head;		
				//where should this loop stop?
				for(int i=0;i<_______;i++) {
					//move placeholder forward
					temp = ________________;
				}
				//set temp's next's previous to node 
				________________;

				//set node's next to temp's next
				________________;

				//set node's previous to temp
				________________;

				//set temp's next to node
				________________;
			}
			
			//adjust size
			__________________;
		}
	}

	public void removeAt(int n) {
		//special case -- want to remove first element
		if(n==0) {
			______________;
		}
		//special case -- want to remove last element
		else if(n==size-1) {
			______________;
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
				________________;
				
				//set temp's next to temp's next's next
				________________;
				
				//set temp's next's previous to temp
				________________;
				
				//set t's next and previous to null -- why?
				t.setNext(__________);
				t.setPrev(__________);
			}
			else {
				//start at beginning
				DNode temp = head;		
				for(int i=0;i<n-1;i++) {
					temp = temp.getNext();
				}
				//create node t to point at temp's next
				________________;
				
				//set temp's next to temp's next's next
				________________;
				
				//set temp's next's previous to temp
				________________;
				
				//set t's next and previous to null -- why?
				t.setNext(__________);
				t.setPrev(__________);
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
		return _______;
	}

	public boolean isEmpty() {
		return ___________;
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
