/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;
import com.google.common.collect.MapMakerInternalMap$WriteThroughEntry;

final class MapMakerInternalMap$ValueIterator
extends MapMakerInternalMap$HashIterator {
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    @Override
    public Object next() {
        return this.nextEntry().getValue();
    }
}

