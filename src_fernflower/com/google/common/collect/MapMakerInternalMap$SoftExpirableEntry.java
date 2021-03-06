package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$SoftEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class MapMakerInternalMap$SoftExpirableEntry extends MapMakerInternalMap$SoftEntry implements MapMakerInternalMap$ReferenceEntry {
   volatile long time = Long.MAX_VALUE;
   MapMakerInternalMap$ReferenceEntry nextExpirable = MapMakerInternalMap.nullEntry();
   MapMakerInternalMap$ReferenceEntry previousExpirable = MapMakerInternalMap.nullEntry();

   MapMakerInternalMap$SoftExpirableEntry(ReferenceQueue var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4) {
      super(var1, var2, var3, var4);
   }

   public long getExpirationTime() {
      return this.time;
   }

   public void setExpirationTime(long var1) {
      this.time = var1;
   }

   public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
      return this.nextExpirable;
   }

   public void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      this.nextExpirable = var1;
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
      return this.previousExpirable;
   }

   public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      this.previousExpirable = var1;
   }
}
