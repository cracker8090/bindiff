package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$IntegerParser;

class CacheBuilderSpec$InitialCapacityParser extends CacheBuilderSpec$IntegerParser {
   protected void parseInteger(CacheBuilderSpec var1, int var2) {
      Preconditions.checkArgument(var1.initialCapacity == null, "initial capacity was already set to ", new Object[]{var1.initialCapacity});
      var1.initialCapacity = Integer.valueOf(var2);
   }
}
