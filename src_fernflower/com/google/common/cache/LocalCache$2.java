package com.google.common.cache;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$2 extends AbstractQueue {
   public boolean offer(Object var1) {
      return true;
   }

   public Object peek() {
      return null;
   }

   public Object poll() {
      return null;
   }

   public int size() {
      return 0;
   }

   public Iterator iterator() {
      return ImmutableSet.of().iterator();
   }
}
