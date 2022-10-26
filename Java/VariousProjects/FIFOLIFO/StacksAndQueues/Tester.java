import java.util.Scanner;
import java.io.*;


public class Tester {

   public static void main(String [] args) throws Exception {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Give me a filename: ");
      String b = keyboard.nextLine().trim();
   
      Scanner file = new Scanner(new File(b));
      
      String s = file.nextLine();
         
         
      while(file.hasNextLine()){
      //create a Scanner based on line
      Scanner line = new Scanner(s);  //say s = "B:10:5"
      line.useDelimiter(":");
      //System.out.println(Rs);
      //System.out.println(line.next());
      // if(line.next().equals("B")){
//          System.out.println("Buying " +  line.next() + " item at " + line.next() + "cost");
//          s = file.nextLine();
//       }
//       else if(line.next().equals("S")){
//          System.out.println("Selling " +  line.next() + " item at " + line.next() + "cost");
//          s = file.nextLine();     
//       }
      

       String record = line.next();

       int units = line.nextInt();
 
       int price = line.nextInt();
       System.out.println(record + " " + units + " " + price);
       
       s = file.nextLine();
       
       //System.out.println(record + units + price);
      
     }

   
   }
   
   
}
