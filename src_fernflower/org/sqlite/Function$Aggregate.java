package org.sqlite;

import org.sqlite.Function;

public abstract class Function$Aggregate extends Function implements Cloneable {
   protected final void xFunc() {
   }

   protected abstract void xStep();

   protected abstract void xFinal();

   public Object clone() {
      return super.clone();
   }
}
