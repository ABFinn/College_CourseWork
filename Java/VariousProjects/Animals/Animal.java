//base, parent, or super class
//child of subclass

public class Animal {

   //data/variables (properties or attributes)
   protected double weight;
   protected boolean warmBlooded;
   protected byte vore;
   public static final byte HERBIVORE = 0;
   public static final byte CARNIVORE = 1;
   public static final byte OMNIVORE = 2;
   
   //methods (actions)
   //Constructors(s)
   //Initializated and instantiate any instance variables
   public Animal(){
      weight = 1;
      warmBlooded = true;
      vore = OMNIVORE; 
   
   }
   
   public Animal(double w, boolean warmBlooded, byte vore) {
      weight = w;
      this.warmBlooded = warmBlooded;
      this.vore = vore;
   
   }
   
   //getter/setter methods (accessor/mutator)
   public double getWeight(){
      return weight;
   }
   public boolean getWarmBlooded(){
      return warmBlooded;
   }
   public byte getVore(){
      return vore;
   }
   public void setWeight(double w){
      weight = w;
   }
   public void setWarmBlooded(boolean b){
      warmBlooded = b;
   }
   public void setVore(byte v){
      vore = v;   
   }
   //action methods
   //sleep eat exert move
   public void eat(double amount){
      weight += amount;
   }
   public boolean exert(double amount){
      
      if(amount < weight){
         weight -= amount;
         return true;
      }
      else{
         return false;
      }
   }
   
   //utility methods
   //equals toString
   public boolean equals(Animal other) {
      //check if two animals are the same
      if(vore == other.getVore() && warmBlooded == other.getWarmBlooded()){
         return true;
      }
      else{
         return false;
      }
   }
   public String toString() {
      String s = "";
      s += "Weight: " + weight; // s = s + "Weight: " + weight;
      s += "\nWarm-blooded: " + warmBlooded;
      s += "\nVore: " + vore;
      
        return s;
   
   }
   
   public static void main(String [] args){
      Animal a = new Animal();
      Animal b = new Animal(53.3,true,Animal.OMNIVORE);
      a.getWeight(); //True
      a.setWarmBlooded(false); //Set a to cold blooded
      a.eat(10); //gain 10 weight
      a.exert(15); //lose 15 weight
      System.out.println(a.equals(b));
      a.equals(b); //would return true
      System.out.println(a.toString()); 

   
   }


}
/*
Animal a = new Animal();
Animal b = new Animal(53.3,true,Animal.OMNIVORE);
a.getWeight() == 1; //True
a.setWarmBlooded(false); //Set a to cold blooded
a.eat(10); //gain 10 weight
a.exert(15); //lose 15 weight
a.equals(b); //would return true
System.out.println(a.toString()); == 
*/


