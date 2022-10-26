

public class ArrayStack <E> implements Stack <E> {
   //instance variables
   E [] stack;
   int top;
   
   public ArrayStack () {
      top = 0;
      stack = (E []) new Object[100];
   
   }
   public void push(E e) throws StackFullException {
      if(top == stack.length){
         throw new StackFullException("Array is full");
      }
      
      stack[top] = e;
      top++;
   }
   
   public E pop() throws StackEmptyException{
      if(top == 0) {
         throw new StackEmptyException("Array is empty");
      }
      top--;
      E temp = stack[top];
      stack[top] = null;
      return temp;
   }
   
   public E top() throws StackEmptyException{
      if(top == 0) {
         throw new StackEmptyException("Array is empty");
      }
      
      return stack[top-1];
   
   }
   
   public int size(){
      return top;   
   }
   
   
   public boolean isEmpty(){
      return top == 0;     
   }
}