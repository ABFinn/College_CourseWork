import java.util.Scanner;

public class GettingInput {
   public static void main(String [] args){
      
         Scanner keyboard = new Scanner(System.in);
         
         System.out.println("Give me a number: ");
         int x = keyboard.nextInt();
         System.out.println("Give me another number: ");
         int y = keyboard.nextInt();
         
         System.out.println("Sum is : " + (x+y));
         
         String input = "";
         while(!input.equalsIgnoreCase("q")){
            System.out.println("Gimme");
            input = keyboard.next();
            System.out.println(input);
            
            }
         
   }

}