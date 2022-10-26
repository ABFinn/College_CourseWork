


public class TreeTester {


   public static void main(String [] args) {
   
      LinkedBinaryTree <String> tree = new LinkedBinaryTree <String> ();
      
      Position <String> node = tree.addRoot("+");
      
      tree.addLeft(node,"2");
      tree.addRight(node,"*");
      
      node = tree.right(node);
      tree.addLeft(node,"-");
      tree.addRight(node,"5");
      
      
      node = tree.left(node);
      tree.addLeft(node,"7");
      tree.addRight(node,"8");
      //LinkedBinaryTree.parenthesize(tree,tree.root());
      
      //node = tree.parent(node);
      
      for(String n : tree) {
         System.out.print(n + " " );
      }
      
   }

}