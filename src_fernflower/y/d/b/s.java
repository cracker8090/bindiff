package y.d.b;

import java.util.Comparator;

class s implements Comparator {
   public int compare(Object var1, Object var2) {
      if(var1 == var2) {
         return 0;
      } else {
         y.d.t var3 = (y.d.t)var1;
         y.d.t var4 = (y.d.t)var2;
         return var3.b() < var4.b()?-1:(var3.b() > var4.b()?1:0);
      }
   }
}
