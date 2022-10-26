import java.util.Scanner;

/*
Recursion - functions that call themselves
          - must pass a subproblem on subsequent calls
Two Parts:
   1. Base case() - when you "know" the answer to simplest version
   2. Recursive case(s) - call same function but w/ smaller problem      

*/

public class RecursionExamples{

   public static void main(String [] args){
      Scanner keyboard = new Scanner(System.in);
      /*
      System.out.println("Give a number: ");
      long n = keyboard.nextInt();
      long sum = summation_iter(n);
      System.out.println("Sum of #'s 1 to " + n + " is " + sum);
      long factorial = factorial(n);
      System.out.println(n + "!" + " is " + factorial);
      */
      
      System.out.println("Which fibonnaci #: ?");
      int n = keyboard.nextInt();
      long fib = fibonacci(n);
      System.out.println("The " + n + "-th fib is " + fib);
      
      int [] ary = {1, 4, 7, 9, 13, 27, 34, 45, 65, 67, 73, 85, 88, 91, 99, 99}
      boolean foundNumber = binarySearch(ary, 0, ary.length-1, 13);
      
      
   
   }
   
   public static long factorial(long n) {
   if(n == 1) {
         return 1;
      }
      
      //recursive case(s)   
      return n * factorial(n-1);   
   
   }
   
   public static boolean binarySearch(int [] ary, int l, int r, int val){
      //base case
      //we've found our number
      int mid = (l+r) /2;
      if(ary[mid] == val) {
      
         return true;
      }
      
      //no numbers left to look through
      
      //recursive case
   
   }
   
   
   
   
   public static long summation_iter(long n){
      long answer = 0;
      for(int i = 0; i <= n; i++){
         answer += i;
      
      }
      
      return answer;
   
   }
   
   public static long summation_recur(long n){
      //base case(s)
      if(n == 1) {
         return 1;
      }
      
      //recursive case(s)   
      return n + summation_recur(n-1);   
      }
   
   public static long fibonacci(long n) {
      //base case(s)
      if(n == 1 || n == 2) {
         return 1;
   
      }
   
      //recursive case(s)
         return fibonacci(n-1) + fibonacci(n-2);
   
      }

}