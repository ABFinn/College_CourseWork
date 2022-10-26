import java.util.Scanner;

public class StackAndQueueTester {

   public static void main(String [] args) {
   
      Stack <Character> aStack = new ListStack <Character> ();
      
      Queue <Character> aQueue = new ArrayQueue <Character> ();
      
      Queue <Character> bQueue = new ListQueue <Character> ();
      
      
      
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Give me a string: ");
      String s = keyboard.nextLine().trim();
      
      
      
      for(int i = 0; i <s.length(); i++){
         char c = s.charAt(i);
         bQueue.enqueue(c);   
      }
      
      System.out.println(bQueue.toString());
      /*
      System.out.println(s);
      for(int i=0;i<s.length();i++){
         char c = s.charAt(i);
         aQueue.enqueue(c);     
      }
      System.out.println(aQueue.toString());
      //System.out.println(aQueue.front());
      aQueue.dequeue();
      System.out.println(aQueue.toString());
      //System.out.println(aQueue.front());
      aQueue.dequeue();
      System.out.println(aQueue.toString());
      aQueue.enqueue('b');
      System.out.println(aQueue.toString());
      aQueue.dequeue();
      System.out.println(aQueue.toString());
      
      */
      
      /*     
      System.out.println("\n\nAnalyzing " + s + "\n\n");
      for(int i=0;i<s.length();i++) {
         //extract i-th character from s
         char c = s.charAt(i);
                  
         //if it's a (, what do I do?
         if(c=='(') {
            aStack.push(c);
         }
         //if it's a ), what do I do?
         if(c==')') {
            try {
               aStack.pop();
            }
            catch(StackEmptyException e) {
               System.out.println("Found unmatched ) at " + i);
            }
         }
         //what if it's not a ( or a ) character?  
      }
      
      if(aStack.size() > 0) {
         System.out.println(aStack.size() + " unmatched ('s");
      }
      */

   }

}