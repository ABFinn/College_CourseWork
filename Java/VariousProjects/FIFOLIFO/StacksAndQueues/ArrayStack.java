public class ArrayStack <E> implements Stack <E> {

   E [] stack;
   int size;
   int top; //do we really need this?
   
   public ArrayStack() {
      stack = (E []) new Object [21];
      size = 0;
      top = 0;
   }
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size==0;
   }
   
   public void push(E e) {
      if(size == stack.length) {
         //create a new (bigger) array
         E [] temp = (E []) new Object[stack.length*2];
         //copy everything over
         for(int i=0;i<stack.length;i++) {
            temp[i] = stack[i];
         }
         stack = temp;
      }
      
      stack[size] = e;
      
      //increment size
      size++;
      
   }
   
   public E pop() throws EmptyStackException {
      if(size==0) {
         throw new EmptyStackException("Stack empty!!!");
      }
      size--;
      E temp = stack[size];
      stack[size] = null;
      return temp;
   }
   
   public E top() throws EmptyStackException {
      if(size==0) {
         throw new EmptyStackException("Stack empty!!!");
      }
      return stack[size-1];   
   }
   


}