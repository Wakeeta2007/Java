import java.util.Scanner;

public class CamelCase {
   public CamelCase() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Enter the string :");
      String var2 = var1.nextLine();
      String[] var3 = var2.split(" ");

      for(int var4 = 0; var4 < var3.length; ++var4) {
         System.out.println(var3[var4]);
      }

      String var6 = var3[0];

      for(int var5 = 1; var5 < var3.length; ++var5) {
         var6 = var3[var5].replaceFirst(" ", var3[var5].substring(0, 1).toUpperCase());
      }

      System.out.println(var6);
   }
}
