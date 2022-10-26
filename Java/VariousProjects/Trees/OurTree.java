import java.util.ArrayList;

public class OurTree <E> extends AbstractTree <E> {

   protected static class Node <E> implements Position <E> {
      private E ele;
      private Node <E> parent;
      private ArrayList <Node <E>> children;
     
      public Node(E e, Node <E> p) {
         ele = e;
         parent = p;
         children = new ArrayList <Node <E>>();
      }
      public E getElement() {
         return ele;
      }
      public Node <E> getParent() {
         return parent;
      }
     public ArrayList <Node <E>> getChildren() {
         return children;
      }
      public Node <E> getChild(int i) throws IllegalArgumentException {
        if(i<0 || i>=children.size()) {
            throw new IllegalArgumentException("Invalid child index");
         }
         return children.get(i);
     }
     
      public void setElement(E e) {
         ele = e;
      }     
      public void setParent(Node <E> p) {
         parent = p;
      }
     
      public Position <E> addChild(Node <E> c) {
         children.add(c);
         return (Position <E>) c;
      }
     
      public void removeChild(Node <E> c) {
         children.remove(c);
      }
     
      public void clearChildren() {
         children.clear();
      }
   }
  

   //INSTANCE VARIABLES!!!
   protected Node <E> root;
   private int size;
  
  
   public OurTree() {
     root = null;
	   size = 0;
   }
  
   protected Node <E> createNode(E e, Node <E> p) {
      return new Node <E> (e, p);
   }
  
   protected Node <E> validate(Position <E> p) throws IllegalArgumentException {
      if(!(p instanceof Node)){
         throw new IllegalArgumentException("Not valid position type");
      }
     Node <E> node = (Node <E>) p; //how do we know this is safe to do?

      if(node.getParent() == node) { //when we remove a node, we'll set it's parent to itself to flag it
         throw new IllegalArgumentException("That position is not in this tree.");
      }     
      return node;
   }
  
  
   //METHODS TO FILL IN

   public int size() {
      return size;
   }


   public Position <E> root() {
      return root;
   }
  
   public Position <E> parent(Position <E> p) throws IllegalArgumentException {
     //validate the position, storing it as a Node
      Node <E> n = validate(p);
     //return the node's parent
      return n.getParent();

   }

   public ArrayList <Position <E>> children(Position <E> p)  throws IllegalArgumentException {
       //validate the position, storing it as a node	
       Node <E> node = validate(p);       
       
       //create an ArrayList of type Position<E>
       ArrayList <Position <E>> kids = new ArrayList <Position <E>>();

       //for each child in the node's children list
         //add the child to the ArrayList
      for(Position <E> c : node.getChildren()){
         kids.add(c);
      
      }
       //return the ArrayList
      return kids;
 
   }
  
  
   public Position <E> getChild(Position <E> p, int i)  throws IllegalArgumentException {
       //validate the position, storing it as a node
      Node <E> node = validate(p);

       //return the node's i-th child
      return node.getChild(i);
 
   }

   public Position <E> addRoot(E e) throws IllegalStateException {
       //if the root is not null (doesn't already exist)
       if(root != null){
         //throw an IllegalStateException
         throw new IllegalStateException("Root already exists");
      }
       //create a new Node with a null parent based on e
       
       root = new Node(e, null);


       //set size to 1
       size = 1;
       

       //return the new node (root)
       return root;

   }
  
   public Position <E>  addChild(Position <E> p, E e)  throws IllegalArgumentException {

       //validate the position, storing in a Node
       Node <E> node = validate(p);

       //create a new node with the ^ node as the parent 
       Node <E> child = new Node(e, node);

       //add the new node as a child to its parent, returning that new Position
       node.addChild(child);
       
       return p;

   }
  
   public int numChildren(Position <E> p) throws IllegalArgumentException {
       //validate the position, storing in a Node variable
       Node <E> node = validate(p);
       //return the number of children of that node
       return node.getChildren().size();
   }
   public E set(Position <E> p, E e)  throws IllegalArgumentException {
      //validate the position, storing in a Node variable
      Node <E> node = validate(p);
      //get the element stored in the node, storing in a temp variable
      E oldValue = p.getElement();
      //change the node's element to e
      node.setElement(e);
      //return the temp value (the old value of the Node)
      return oldValue;

   }
  
   public E remove(Position <E> p)  throws IllegalArgumentException {
      //validate the position, storing in a Node variable
      Node <E> nodeToRemove = validate(p);
      //get the parent of the Node, storing in a temp variable
      Node <E> parent = nodeToRemove.getParent();
      //get the List of childen of the Node, storing in an ArrayList
      ArrayList <Node <E>> children = nodeToRemove.getChildren();
      //3 cases - the node is a root, the node is a leaf, or the node 
      //is a non-root internal node

      //if the node is the root f the tree
      if(parent == null){
        //if the root has no children
        if(nodeToRemove.getChildren().size() == 0){
          //null out the root
          root = null;
          }
        else{
        //else promote the first child to replace the root
          //set root to 0-th child of current root
          root = nodeToRemove.getChild(0);
          //for each child of node (the old root)
            //add the child to the new root's list of children
          for(int i = 1; i < numChildren(nodeToRemove);i++){
            root.addChild(nodeToRemove.getChild(i));
          }
          //set the new root's parent to null
          root.setParent(null);
          }
      }
      //else if p is an external node/position (a leaf)
      else if(children.size() == 0){
        //remove the node from the child list of it's parent
        parent.removeChild(nodeToRemove); 
      }
      
      //else it's a non-root internal node
      else{
        //promote first child
        //get the i-th child of the node (call it something like firstChild)
        Node <E> firstChild = nodeToRemove.getChild(0);
        //add that firstChild node as a child of the parent node
        parent.addChild(firstChild);
        //remove the node from the parent's list of nodes
        parent.removeChild(nodeToRemove);

        //for each of the other kids of node
        for(int i = 1; i < numChildren(nodeToRemove); i++){
          //add the child to children of firstChild
          firstChild.addChild(nodeToRemove.getChild(i));
        }
      }


      //decrement size
      size--;

      //get the element out of the Node, storing in a temp variable
      E temp = nodeToRemove.getElement();
      //set parent to itself
      nodeToRemove.setParent(nodeToRemove);
      //null out the element of the node
      nodeToRemove.setElement(null);
      //clear out the children list of the node
      nodeToRemove.clearChildren();
      //return temp value
      return temp;

   }
  

}

