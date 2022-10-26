public class EulerProjects{
   public static void main(String [] args) {
   
      //System.out.println(euler1(1000));
      //System.out.println(isPrime(1));
      //System.out.println(euler2(4000000));
      //System.out.println(euler3(600851475143l))
      //System.out.println(euler5(0));
      //System.out.println(euler6(100));
      //System.out.println(euler7(10001));
      System.out.println(euler5(10));
   
   }
   public static int euler1(int limit) {
      
      int sum = 0;
      int num = 3;
      while(num < limit){
         if(num % 3 == 0 || num % 5 == 0){
            sum = sum + num;
         }
      num++;
      }
      return sum;
   }
   public static boolean isPrime(long n){
      
      
      if(n == 2){
         return true;
      }
      if(n % 2 == 0) {
         return false;
      }
      
      long factor = 3;
      
      while(factor <= Math.sqrt(n)){
         //if factor is a factor of n
         if(n % factor == 0){
            return false;      
         }
         factor = factor + 2;
        }
       return true;
   
   }
   public static long euler2(int limit){
   
      //create an accumulator variable
      long sum = 0;
      int fib1 = 1;
      int fib2 = 2;
      
      while (fib2 < limit){
         if(fib2 % 2 == 0){
            sum += fib2; //sum = sum + fib
         }
         fib2 += fib1;
         fib1 = fib2 - fib1;
         
      }
      
      
      return sum;
   }
   public static long euler3(long limit){      
      
      
      while(isPrime(limit) == false){
         int i = 2;
         while(true){
            if(limit % i == 0 && isPrime(i) == true){
               break;
            }
            else{
            i++;
            }
           }
            limit = limit/i;
           }               
      return limit;
         
      
   }
   public static int euler5(int limit){
      int i = 20;
      while(true){
         if(i % 11 == 0 && i % 12 == 0 && i % 13 == 0 && i % 14 == 0 && i % 15 == 0 && i % 16 == 0 && i % 17 == 0 && i % 18 == 0 && i % 19 == 0){
            break;
         }
         else{
         i = i + 20;
         }
        }      
         return i;
      
      
   }


   public static int euler6(int limit){
      int sum = 0;
      int sqsum = 0;
      int diff;
      
      for(int i = 1; i <= limit; i++){
         sum = sum + (int) Math.pow(i,2);      
      }
      
      for(int i = 1; i <= limit; i++){
         sqsum = sqsum + i;           
      }
      sqsum = (int) Math.pow(sqsum, 2);
      diff = sqsum - sum;
   
   
      return diff;
   }
  public static long euler7(long limit){
  int prime = 0;
  int count = 0;

  
  while(count <= limit){
   prime++;
   if (isPrime(prime) == true){
      count++;
   }

     }  
   return prime;
  }
  public static long euler9(long limit){
  int a = 0;
  int b = 0;
  int c = 0;
  
  while(true){
  if(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) == limit && a < b && b < c){
      break;
  }
  else{
  
  }
  
  }
  
  
  return a * b * c;
  }
  public static long euler10(long limit){
  long num = 0;
  long i = 0;
  while(i < limit){
   if(isPrime(i) == true){
   num = num + i;
   i++;
   }
   else{
   i++;
   }
  
  }
  return num;
 }
  
}


