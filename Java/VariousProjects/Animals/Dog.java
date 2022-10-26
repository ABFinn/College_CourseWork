public class Dog extends Animal {
   
   
   protected String name;
   protected String breed;
   
   public Dog(String n, String b, double w, boolean wb, byte v){
      super(w,wb,v);
      name = n;
      breed = b;
      
   }
   
   public String speak(){
      if(weight <10) {
         return "arf";
      }
      else if(weight < 40) {
         return "ruff";
      }
      else if(weight > 40) {
         return "woof";
      }
      else{
      
      return "no";
      }
   }
   public void eat(double amount){
      weight += amount/2;
   }

   public static void main(String [] args){
      Animal d = new Dog("Sadie","Mix", 45, true, Animal.OMNIVORE);
      System.out.println(((Dog) d).speak());
      //System.out.println(d.speak());
      System.out.println(d.getWeight());
      d.eat(10);
      System.out.println(d.getWeight());
   
   }


}
