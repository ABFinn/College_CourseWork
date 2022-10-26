

public class StackAndQueueTester {


   public static void main(String [] args) {
      
      Queue <Integer> q = new ListQueue<Integer>();
      
      for (int i=1;i<=10;i++) {
         q.enqueue(i);
      }
      while(!q.isEmpty()) {
         System.out.println(q.dequeue());
      }
      
      
      Stack <Integer> stack = new ListStack<Integer>();
      Stack <Integer> stack2 = new ArrayStack<Integer>();
      
      for(int i=1;i<=10;i++) {
         stack.push(i);
      }
      
      while(!stack.isEmpty()) {
         stack2.push(stack.pop());
      }
   
      while(!stack2.isEmpty()) {
         System.out.println(stack2.pop());
      }
      
      
   }


}