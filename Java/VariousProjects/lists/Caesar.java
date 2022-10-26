   import java.util.Scanner;

   public class Caesar {
   
      public static final int ALPHASIZE = 26;
      public static final char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','Q','R','S','T','U','V','W','X','Y','Z'};
   
   //protected char[] encrypt = new char[ALPHASIZE];
   //protected char[] decrypt = new char[ALPHASIZE];
   
   //	public Caesar() {
   //	}
   
      public static String encrypt(String secret) {
      
         int shift=3;
         String answer = "";
         for (int i=0;i<secret.length();i++) {
            answer += (char) ((secret.charAt(i) - 'a' + shift) % 26 + 'a');		
         }
         return answer;
      }
   
      public static String decrypt(String secret) {
         int shift=3;
         String answer = "";
         for (int i=0;i<secret.length();i++) {
            answer += (char) ((secret.charAt(i) - 'a' - shift) % 26 + 'a');		
         //			answer += (char) (secret.charAt(i) - shift);		
         }
         return answer;
      
      }
   
   
      public static void main(String [] args) {
         Scanner input = new Scanner(System.in);
         System.out.print("Enter a word: ");
         String s = input.nextLine().toLowerCase();
         System.out.println("Your message (uppercase): " + s);
         s = encrypt(s);
         System.out.println("Encoded: " + s);
         s = decrypt(s);
         System.out.println("Successfully decrypted? " + s);
      }
   }
