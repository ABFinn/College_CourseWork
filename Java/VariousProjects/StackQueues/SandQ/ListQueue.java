import java.util.LinkedList;

public class ListQueue <E> implements Queue <E> {
   
   LinkedList <E> queue;
   
   public ListQueue(){
      queue = new LinkedList <E> ();
   }

   
   public void enqueue(E e) throws QueueFullException{
         queue.addLast(e);

   }
   public E dequeue() throws QueueEmptyException{
      return queue.removeFirst();
   
   }
   public E front() throws QueueEmptyException{
      return queue.getFirst();
   
   }
   public int size(){
      return queue.size();
   
   }
   public boolean isEmpty(){
      return queue.size() == 0;
   
   }


}
