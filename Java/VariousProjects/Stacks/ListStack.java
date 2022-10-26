import java.util.LinkedList;

public class ListStack <E> implements Stack <E> {
   //instance variables
   LinkedList <E> stack;

   public ListStack(){
      stack = new LinkedList <E> ();
   }
   
   public void push(E e) throws StackFullException{
      stack.addFirst(e); 
   }
   
   public E pop() throws StackEmptyException{
      if(stack.size() == 0){
         throw new StackEmptyException("List is empty");
      }
      return stack.removeFirst();
   }
   
   public E top() throws StackEmptyException{
      if(stack.size() == 0){
         throw new StackEmptyException("List is empty");
      }
      return stack.getFirst();

   }
   
   public int size(){
   
      return stack.size();
   }
   
   public boolean isEmpty(){
   
      return stack.size() == 0;
   }

}