

public class ArrayQueue <E> implements Queue <E> {

   E [] queue;
   int back;
   int front;
   
   public ArrayQueue () {
      int back = 0;
      int front = 0;
      queue = (E []) new Object[100];   
   }

   public void enqueue(E e) throws QueueFullException{
      if(back == queue.length) {
         throw new QueueFullException("Your Queue has run out of room");
      }
      queue[back] = e;
      back++;
   
   }
   public E dequeue() throws QueueEmptyException{
      if(back == front) {
         throw new QueueEmptyException("Your Queue has nothing in it");
      }
      E temp = queue[front];
      for(int i = 1; i < back;i++){
         queue[i - 1] = queue[i];
      }
      queue[back] = null;
      back--;
      return temp;
   
   }
   public E front() throws QueueEmptyException{
      if(back == front) {
         throw new QueueEmptyException("Your Queue has nothing in it");
      }
   
      return queue[front];
   
   }
   
   public int size(){
      return back;
   
   }
   public boolean isEmpty(){
      return front == back;  
   }
   
   public String toString(){
      String s = "";
      for(int i = 0; i < queue.length;i++){
      s = s + "[" + queue[i] + "]";
      
      }
   return s;
   }

}