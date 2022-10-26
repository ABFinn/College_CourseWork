//driver class  - FIFOLIFO
import java.util.Scanner;
import java.io.*;


public class FIFOLIFO {

   public static void main(String [] args) throws Exception {
   
      Stack <Integer> lifo = new ListStack <Integer> ();
      Queue <Integer> fifo = new ListQueue <Integer> ();
      int lifoProfit = 0;
      int fifoProfit = 0;
      String record = "";
      int units = 0;
      int price = 0;
      
      //ask the user for the inventory file name
      
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Give me a filename: ");
      String b = keyboard.nextLine().trim();
      
      //open up the file using a Scanner
      Scanner file = new Scanner(new File(b));
      
      //for each line in the file
      
      //while file has next (line)
      while(file.hasNextLine()){
      
         //read the next line (using nextLine() method)
         String s = file.nextLine();
         
         //create a Scanner based on line
         Scanner line = new Scanner(s);  //say s = "B:10:5"
         line.useDelimiter(":");
         
         //extract the record type, storing it in a String  (use next()
         record = line.next();
         
         //extract the number of units (use nextInt())
         units = line.nextInt();
         //extract the price (use nextInt())
         price = line.nextInt();
         
         System.out.println(record + " " + units + " " + price);
         
         //if record type is "B"
            //loop number of units times
               //enqueue price into fifo
               //push price onto lifo
         if(record.equals("B")){
            for(int i = 0; i < units; i ++){
               fifo.enqueue(price);
               lifo.push(price);
            
            }
            //System.out.println("Fifo size: " + fifo.size());
            //System.out.println("Lifo size: " + lifo.size());
         
         }
         
               
         //if record type is "S"
            //loop number of units times
               //queue
               //dequeue element from queue, subtracting that number from price
               
         else if(record.equals("S")){
            for(int i = 0; i < units; i++){
              fifoProfit = fifoProfit + (price - fifo.dequeue());
              lifoProfit = lifoProfit + (price - lifo.pop());        
            }   
          }               
           
           //System.out.println("Fifo Profit: " + fifoProfit);
           //System.out.println("Lifo Profit: " + lifoProfit);         
         
      }
         
      //end file loop
      
      //output to user the different profits (fifoProfit and lifoProfit)
      
      System.out.println("Fifo Profit: " + fifoProfit);
      System.out.println("Lifo Profit: " + lifoProfit); 
   
   }

}