import java.util.ArrayList;


public class OurTreeTester {


   public static void main(String [] args) {
   
      OurTree <Integer> tree = new OurTree<Integer>();
      Position <Integer> root = tree.addRoot(0);
      Position <Integer> node = tree.addChild(root, 1);
      tree.addChild(node, 3);
      tree.addChild(node, 4);
      
      node = tree.addChild(root,2);
      tree.addChild(node,5);
      tree.addChild(node,6);
      
      
      //now try to print the tree....
      
      node = tree.root();
      System.out.println("root: " + node.getElement());
      ArrayList <Position <Integer>> kids = tree.children(node);
      for(int i=0;i<kids.size();i++) {
         System.out.print(kids.get(i).getElement() + " ");
      }
      System.out.println();

      tree.remove(root);      


      node = tree.root();
      System.out.println("root: " + node.getElement());
      kids = tree.children(node);
      for(Position <Integer> kid : kids) {
         System.out.print(kid.getElement() + " " );
      }
      System.out.println();
      
   }


}