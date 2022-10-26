
public class ListQueue <E> implements Queue <E> {

   SinglyLinkedList <E> queue;
   
   public ListQueue() {
      queue = new SinglyLinkedList <E> ();
   }

   public int size() {
      return queue.size();
   }
   public boolean isEmpty(){ 
      return queue.size() == 0;
   }
   public void enqueue(E e) {
      queue.addLast(e);
   }
   public E dequeue() throws EmptyQueueException {
      if(queue.size()==0) {
         throw new EmptyQueueException("Empty queue!!!");
      }
      return queue.removeFirst();
   }
   public E front() throws EmptyQueueException {
      if(queue.size()==0) {
         throw new EmptyQueueException("Empty queue!!!");   
      }
      return queue.first();   
   }


}