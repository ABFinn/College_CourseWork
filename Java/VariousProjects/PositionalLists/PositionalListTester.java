import java.util.ArrayList;


public class PositionalListTester {
	

	public static void main(String [] args) {

		PositionalList <Integer> list = new LinkedPositionalList<Integer> ();
      ArrayList <Integer> numbers = new ArrayList <Integer>();

      for(int i = 0; i<10;i++){
         numbers.add(i);
      }
      
      for(Integer n : numbers) {
         System.out.println(n);
      }

      // int i = 1;
//       Position <Integer> p = list.addFirst(i);
//       
//       while(i < 10){
//          i++;
//          p = list.addAfter(p, i);
//       
//       }
//       
//       p = list.first();
//       System.out.println(p.getElement());
//       for(i = 1; i<list.size(); i++){
//          p = list.after(p);
//          System.out.println(p.getElement());
//       }
      
	}

}