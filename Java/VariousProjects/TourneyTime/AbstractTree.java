

public abstract class AbstractTree <E> implements Tree <E> {
   
   //what methods aren't we implementing here? why?
   
   
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
 

   //depth and height - should these be in abstract class? 
   //that is, are they the same for any kind of tree?



   public int depth(Position <E> p) {
      if (isRoot(p)) {
        return 0;
      }
      else {
         return 1 + depth(parent(p));
     }
   }
   
   private int heightBad() {
      int h=0;
      for(Position <E> p : positions()) {
         if(isExternal(p)) {
            h=Math.max(h,depth(p));
         }
      }
      return h;
   }
  
   //RECURSION FTW!
   public int height(Position <E> p){
      int h = 0;
      for(Position <E> c : children(p)) {
         h = Math.max(h,1+height(c));
      }
      return h;
   }
}

