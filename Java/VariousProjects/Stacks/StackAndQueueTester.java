import java.util.Scanner;

public class StackAndQueueTester {

   public static void main(String [] args){
      ListStack <Character> aStack = new ListStack <Character> ();
      //Stack <Integer> aStack = new ListStack <Integer> (); also works
      
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Give me a string of parentheses: ");
      String s = keyboard.nextLine().trim();
      
      System.out.println("\n\nAnalyzing " + s + "\n\n");   
      
      for(int i =0;i<s.length();i++){
         //extract i-th character from s
         char c = s.charAt(i);
         //if it's a (, what do I do?
         if(c == '('){
            aStack.push(c);
         }
         //if it's a ), what do I do?
         if(c == ')'){
            try{
               aStack.pop();
            }
            catch(StackEmptyException e) {
               System.out.println("Found unmatched ) at " + i);
            }
         }
         
         //what if it's not a ( or ) character?
         
      
      }
      if(aStack.size() > 0) {
            System.out.println(aStack.size() + " unmatched ('s");
         
         }
   }


}