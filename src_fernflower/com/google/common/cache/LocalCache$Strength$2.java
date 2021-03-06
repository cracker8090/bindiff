package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$SoftValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedSoftValueReference;

enum LocalCache$Strength$2 {
   LocalCache$ValueReference referenceValue(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, Object var3, int var4) {
      return (LocalCache$ValueReference)(var4 == 1?new LocalCache$SoftValueReference(var1.valueReferenceQueue, var3, var2):new LocalCache$WeightedSoftValueReference(var1.valueReferenceQueue, var3, var2, var4));
   }

   Equivalence defaultEquivalence() {
      return Equivalence.identity();
   }
}
