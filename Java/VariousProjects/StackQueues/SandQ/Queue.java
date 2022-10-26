

public interface Queue <E> {

   
   public void enqueue(E e) throws QueueFullException;
   public E dequeue() throws QueueEmptyException;
   public E front() throws QueueEmptyException;
   public int size();
   public boolean isEmpty();
   

}