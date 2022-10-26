

public interface Stack <E> {
   public void push(E e) throws StackFullException;
   
   public E pop() throws StackEmptyException;
   
   public E top() throws StackEmptyException;
   
   public int size();
   
   public boolean isEmpty();

}