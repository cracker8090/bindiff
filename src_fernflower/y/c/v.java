package y.c;

import y.c.d;
import y.c.e;
import y.c.q;

class v implements e {
   d a;
   private final q b;

   v(q var1) {
      this.b = var1;
      this.a = var1.c;
   }

   v(q var1, d var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean f() {
      return this.a != null;
   }

   public void g() {
      this.a = this.a.a;
   }

   public void h() {
      this.a = this.a.c;
   }

   public void b() {
      this.g();
      if(this.a == null) {
         this.i();
      }

   }

   public void c() {
      this.h();
      if(this.a == null) {
         this.j();
      }

   }

   public void i() {
      this.a = this.b.c;
   }

   public void j() {
      this.a = this.b.d;
   }

   public int k() {
      return this.b.f;
   }

   public Object d() {
      return this.a;
   }

   public d a() {
      return this.a;
   }
}
