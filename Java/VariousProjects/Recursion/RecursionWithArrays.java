import java.util.Random;
import java.util.Arrays;

public class RecursionWithArrays {
   //Random variable for creating random numbers
   public static Random rdm = new Random();



   public static void main(String [] args) {
   
      int [] data = makeRandomArray(10);
      System.out.print("The array: ");
      System.out.println(Arrays.toString(data));

      int max = findMax(data);
      int min = findMin(data);
      System.out.println("Min / Max: " + min + " / " + max);


      int [] reverse = reverse(data);
      System.out.print("  Reverse: ");
      System.out.println(Arrays.toString(reverse));

      String s = "We the People of the United States, in Order to form a more perfect Union, establish Justice, insure domestic Tranquility, provide for the common defence, promote the general Welfare, and secure the Blessings of Liberty to ourselves and our Posterity, do ordain and establish this Constitution for the United States of America.";
      int numVowels = countVowels(s);
      System.out.println("Preamble has " + numVowels + " vowels.");

   }

   //Given an array of integers, find largest
   //This function will call the actual recursive function (max_aux)
   public static int findMax(int [] ary) {
      return max_aux(ary,0);
   }

   //THIS IS THE RECURSIVE FUNCTION
   //YOU CANNOT USE A LOOP!

   public static int max_aux(int [] ary, int i) {
      //base case
      //how do I know if I'm looking at a solvable
      //problem without another function call?
      if(i == ary.length-1) {
         return ary[i];
      }
 
      
      //recursive case
      int biggestOfRestOfArray = max_aux(ary, i + 1);
     
      if(ary[i] > biggestOfRestOfArray){
         return ary[i];
      }
      else{
         return biggestOfRestOfArray;
      }
      

   }

   //Given an array of integers, find smallest
   //This function will call the actual recursive function (min_aux)
   
   public static int findMin(int [] ary) {
      return min_aux(ary,0);
   }

   //THIS IS THE RECURSIVE FUNCTION
   //YOU CANNOT USE A LOOP!
   public static int min_aux(int [] ary, int i) {

      if(i == ary.length-1) {
         return ary[i];
      }
 
      
      //recursive case
      int biggestOfRestOfArray = min_aux(ary, i + 1);
     
      if(ary[i] < biggestOfRestOfArray){
         return ary[i];
      }
      else{
         return biggestOfRestOfArray;
      }      

   }

   //Method that returns a reversed version of the array passed in
   //This function will call the actual recursive function (reverse_aux)

   public static int [] reverse(int [] orig) {
      //create a new array of size orig.length


      //call recursive function, passing original, reverse, and where you want to start

      //return the reverse array
      
      return orig;
      
   }

   public static void reverse_aux(int [] orig, int [] rev, int counter) {
      //base case



      //recursive case   

   }

   //Count the number of vowels in String s passed to the method
   public static int countVowels(String s) {
      int count = 0;
   	//base case
      

      //recursive case
      
      //substring function
      
      return 5;


   }

   public static int [] makeRandomArray(int size) {
      int [] ary = new int [size];
      for(int i=0;i<size;i++) {
         ary[i] = rdm.nextInt(size);
      }
      return ary;
   }
}

