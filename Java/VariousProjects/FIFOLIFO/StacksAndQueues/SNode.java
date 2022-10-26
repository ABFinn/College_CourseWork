

public class SNode <E> {

   //data element
   protected E ele;
   //reference to the next node
   protected SNode <E> next;
   
   
   public SNode() {
      ele = null;
      next = null;
   }
   
   public SNode(E data) {
      ele = data;
      next = null;
   }
   
   public E getElement() {
      return ele;
   }
   
   public SNode <E> getNext() {
      return next;
   }
   
   public void setElement(E ele) {
      this.ele = ele;
   }
   
   public void setNext(SNode <E> next) {
      this.next = next;
   }
   
   

}