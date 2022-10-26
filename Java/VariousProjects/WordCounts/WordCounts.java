import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.regex.*;
import java.io.*;

public class WordCounts {
	
	public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
		//create an enmpty hashmap
      HashMap <String,Integer> wordCounts = new HashMap <String,Integer> ();
      //create a string w/ words in it
		String words = "The big bear ate the salmon. Don't you like big bananas, Mr. Bear?";
      
      System.out.println("give file:");
      String fname = keyboard.next();
		//create a Scanner pointing at string
      Scanner s = null;
      
      while (s == null) {
      try {
         s = new Scanner(new File(fname));
      }
      catch(Exception e){
         System.out.println("Bad file");
         fname = keyboard.next();
      }
     }
      
      s.useDelimiter("[\\W&&[^']]+");

		//for each word in the scanner
      while(s.hasNext()) {
			String word = s.next().toLowerCase();    
         //if it's already in the hashmap
         if(wordCounts.containsKey(word)){
				//do something
               wordCounts.put(word, 1 + wordCounts.get(word));  
               
            }
			//else if it's not in the hashmap
         else{   
				//add it to the hashmap
               wordCounts.put(word,1);
            }
         }

         System.out.println(wordCounts.size());
         for(Entry <String, Integer> entry : wordCounts.entrySet()) {
         System.out.println(entry.getKey() + " : " + entry.getValue());
         
         }



	}



}