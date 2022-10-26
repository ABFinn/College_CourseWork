import java.io.PrintStream;

public class StringsAndNumbers {

   public static PrintStream out = System.out;

   public static void main(String [] args){
   
      String s = "123";
      String t = "100";
      int a = 100;
      String z = s + a;
      int b = 56;
      //Have to put the arthimetic in parathensis in order for it to go first
      //out.println("The sum of " + a + " and " + b + " is " + (a+b));
      
      s = b + ""; // turn a number into a string
      
      b = ourParseInt(s); //turn a string into an int
      //out.println(b);   
      
      //sum the two numbers passed as command line args
      if(args.length > 0){
         //int m = Integer.parseInt(args[0]);
         //int n = Integer.parseInt(args[1]);
         int sum = 0;
         for(int i =0; i <args.length; i++){
            sum = sum + Integer.parseInt(args[i]);
         }
         out.println("Sum is: " + sum);
      }
      else {
      out.println("need two numbers as args");
      }
   }
   
   public static int ourParseInt(String s) {
      //how do you turn "123" into 123
      int sum = 0;
      for (int i=0 ; i < s.length(); i++) {
         //get i-th character or i-th from the end character
         char c = s.charAt(s.length() - i-1);
         int n = c - '0';
         sum = sum + n * (int) Math.pow(10, i);
      
      
      }
      return sum;
   
   
   }


}