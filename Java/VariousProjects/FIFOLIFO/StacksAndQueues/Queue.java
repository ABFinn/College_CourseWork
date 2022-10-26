
public interface Queue <E> {

   public int size();
   public boolean isEmpty();
   public void enqueue(E e);
   public E dequeue() throws EmptyQueueException;
   public E front() throws EmptyQueueException;


}