

public class ListStack <E> implements Stack <E> {

   SinglyLinkedList <E> stack;
   

   public ListStack() {
      stack = new SinglyLinkedList <E> ();
      
   }
   
   public int size() {
      return stack.size();
   }
   
   public boolean isEmpty() {
      return stack.size() == 0;
   }

   public void push(E e) {
      stack.addLast(e);
   }
   
   public E pop() throws EmptyStackException {
      E e = stack.removeLast();
      if(e == null) {
         throw new EmptyStackException("Stack is empty!!!");
      }
      return e;
      
   }
   
   public E top() throws EmptyStackException {
      E e = stack.last();
      if(e == null) {
         throw new EmptyStackException("Stack is empty!!!");
      }
      return e;   
   }
   
   

}