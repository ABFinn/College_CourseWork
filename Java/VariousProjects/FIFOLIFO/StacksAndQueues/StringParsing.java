import java.util.Scanner;
import java.io.*;

public class StringParsing {

   public static void main(String [] args) throws Exception {
      
      Scanner keyboard = new Scanner(System.in);
      
      String s = "B:10:5";
      
      
      Scanner file = new Scanner(new File("StringParsing.java"));
      
      Scanner stringParser = new Scanner(s);
      
      
      while(file.hasNext()) {
         String line = file.nextLine();
         System.out.println(line);
         
      }
   }
}