import java.util.Iterator;

public interface Tree <E> { // extends Iterable <E> {

   public int size();
   public boolean isEmpty();
   public Position <E> root();
   public Position <E> parent(Position <E> p) throws IllegalArgumentException;
   public Iterable <Position <E>> children(Position <E> p) throws IllegalArgumentException;
   public int numChildren(Position <E> p) throws IllegalArgumentException;   
   public boolean isInternal(Position <E> p) throws IllegalArgumentException;
   public boolean isExternal(Position <E> p) throws IllegalArgumentException;
   public boolean isRoot(Position <E> p) throws IllegalArgumentException;
   //public Iterator <E> iterator();
   //public Iterable <Position <E>> positions(); 

}