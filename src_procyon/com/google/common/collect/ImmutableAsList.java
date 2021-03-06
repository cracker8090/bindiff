package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtCompatible(serializable = true, emulated = true)
abstract class ImmutableAsList extends ImmutableList
{
    abstract ImmutableCollection delegateCollection();
    
    @Override
    public boolean contains(final Object o) {
        return this.delegateCollection().contains(o);
    }
    
    @Override
    public int size() {
        return this.delegateCollection().size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.delegateCollection().isEmpty();
    }
    
    @Override
    boolean isPartialView() {
        return this.delegateCollection().isPartialView();
    }
    
    @GwtIncompatible("serialization")
    private void readObject(final ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new ImmutableAsList$SerializedForm(this.delegateCollection());
    }
}
