

public class SinglyLinkedList <E> {


   protected int size;
   protected SNode <E> head;
   protected SNode <E> tail;


   public SinglyLinkedList () {
      size = 0;
      head = null;
      tail = null;
   }
   
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size==0;
   }
   
   public E first() {
      if(head != null) {
         return head.getElement();
      }
      return null;
   }
   public E last() {
      if(tail != null) {
         return tail.getElement();
      }
      return null;
   }
   
   public void addFirst(E ele) {
      SNode <E> node = new SNode<E>(ele); 
      //list is empty
      if(size==0) {
         head = node;
         tail = node;
         size++;
      }
      //list is not empty
      else {
         node.setNext(head);
         head = node;
         size++;        
      }
   }
   public void addLast(E ele) {
      SNode <E> node = new SNode<E>(ele); 
      //list is empty
      if(size==0) {      
         head = node;
         tail = node;
         size++;
      }
      //list is not empty
      else {
         tail.setNext(node);
         tail=node;
         size++;
      }
   }

   public E removeFirst() {
      //list is empty
      if(size==0) {
         return null;
      }
      //list is not empty
      else {
         SNode <E> data = head;
         head = head.getNext();
         data.setNext(null);
         if(size == 1) {
            tail = null;
         }
         size--;
         return data.getElement();
      }
   }
   
   public E removeLast() {
      if(size==0) {
         return null;
      }
      else if(size==1) {
         SNode <E> temp = head;
         head = null;
         tail = null;
         size--;
         return temp.getElement();
      }
      else {
         SNode <E> data = tail;
         SNode <E> temp = head;
         
         while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
         }
         tail = temp;
         size--;
         tail.setNext(null);
         return data.getElement();
            
      }
   }
   
   public E get(int i){ 
      //check to make sure i is in bounds (between 0 and size)
      if(!(i >= 0 && i < size)){
         throw new IndexOutOfBoundsException("bad index!!!");
      }      
      //start at head of list
      SNode <E> bunny = head;
      //link hop i times
      //for(int idx=0; idx<i; idx++) {
      //   bunny = bunny.getNext();
      //}
      bunny = get_aux(0,i,bunny);
      
      //return that node's element
      return bunny.getElement();
   }
   
   public SNode <E> get_aux(int x, int i, SNode <E> n) {
      if(x == i) {
         return n;
      }
      return get_aux(x+1, i, n.getNext());
   }
   
   public E set(int i, E data) {
      //check to make sure i is in bounds (between 0 and size)
      if(!(i >= 0 && i < size)){
         throw new IndexOutOfBoundsException("bad index!!!");
      }   
      //start at head of list
      SNode <E> bunny = head;
      //link hop i times
      for(int idx=0; idx<i; idx++) {
         bunny = bunny.getNext();
      }
      E temp = bunny.getElement();
      bunny.setElement(data);
      return temp;
   }
   
   public void insert(int i, E data) {
      //check to make sure i is in bounds (between 0 and size)
      if(!(i >= 0 && i <= size)){
         throw new IndexOutOfBoundsException("bad index!!!");
      } 
      if(i==0) {
         addFirst(data);     
      }
      else if(i==size) {
         addLast(data);
      }
      //start at head of list
      SNode <E> bunny = head;
      //link hop i times
      for(int idx=0; idx<i-1; idx++) {
         bunny = bunny.getNext();
      }
      SNode <E> temp = new SNode <E> (data);
      temp.setNext(bunny.getNext());
      bunny.setNext(temp);
      
      size++;
      
   }
   
   //should remove the ith element from the list, returning its data element
   public E remove(int i) {
      //check to make sure i is in bounds (between 0 and size)
      if(!(i >= 0 && i < size)){
         throw new IndexOutOfBoundsException("bad index!!!");
      }   
      if(i==0) {
         return removeFirst();      
      }
      else if(i==size-1) {
         return removeLast();
      }
      else {
         SNode <E> bunny = head;
         for(int idx=0;idx < i-1; idx++) {
            bunny = bunny.getNext();
         }
         
         E temp = bunny.getNext().getElement();
         SNode <E> bunnysFutureNext = bunny.getNext().getNext();
         bunny.getNext().setNext(null);
         bunny.setNext(bunnysFutureNext);
         size--;
         return temp;
         
         
      }
      
   }
   
   public boolean equals(SinglyLinkedList <E> other) {
      if(size != other.size()) {
         return false;
      }
      for(int i=0;i<size;i++) {
         if( this.get(i).equals(other.get(i)) == false) {
            return false;
         }
      }
      return true;
   }
   
   public SinglyLinkedList <E> clone() {
      SinglyLinkedList <E> copy = new SinglyLinkedList <E>();
      
      for(int i=0;i<size;i++) {
         copy.addLast(get(i));
      }
      return copy;
   }
   
   public static void main(String [] args) {
      SinglyLinkedList <Integer> list = new SinglyLinkedList <Integer>();
      
      for(int i=0;i<10;i++) {
         list.addFirst(i);
      }
      System.out.println(list.get(5));
      
      SinglyLinkedList <Integer> list2 = list.clone();
      
   }
}