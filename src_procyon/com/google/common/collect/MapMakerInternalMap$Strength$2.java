package com.google.common.collect;

import com.google.common.base.*;

enum MapMakerInternalMap$Strength$2
{
    MapMakerInternalMap$Strength$2(final String s, final int n) {
    }
    
    @Override
    MapMakerInternalMap$ValueReference referenceValue(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final Object o) {
        return new MapMakerInternalMap$SoftValueReference(mapMakerInternalMap$Segment.valueReferenceQueue, o, mapMakerInternalMap$ReferenceEntry);
    }
    
    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }
}
