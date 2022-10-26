

public abstract class AbstractTree <E> implements Tree <E> {
   public boolean isInternal(Position <E> p) {
	   return numChildren(p) > 0; 
   }

   public boolean isExternal(Position <E> p) {
	   return numChildren(p)==0;
   }

   public boolean isRoot(Position <E> p) {
       return p == root();
   }

   public boolean isEmpty() {
       return size()==0;    
   }

   //NEED TO COMPLETE!!
   public int depth(Position <E> p) {
      //base case
      if(isRoot(p)) {
         return 0;
      }
      //recursive case
      return 1 + depth(parent(p));
   }
  
   //NEED TO COMPLETE!!
   public int height(Position <E> p){
      int h = 0;
      //for each child of p
         //set h to the max of h and the height of hte subtree rooted at that child
      
      for(Position <E> c : children(p)) {
         h = Math.max(h, 1 + height(c));
      }
      
      return h;
   }
}

