
public interface Stack <E> {

   public int size();
   
   public boolean isEmpty();
   
   public void push(E e);
   
   public E pop() throws EmptyStackException;
   
   public E top() throws EmptyStackException;
   

}