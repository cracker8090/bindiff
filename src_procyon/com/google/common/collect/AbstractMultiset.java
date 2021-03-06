package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
abstract class AbstractMultiset extends AbstractCollection implements Multiset
{
    private transient Set elementSet;
    private transient Set entrySet;
    
    @Override
    public int size() {
        return Multisets.sizeImpl(this);
    }
    
    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.count(o) > 0;
    }
    
    @Override
    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }
    
    @Override
    public int count(@Nullable final Object o) {
        for (final Multiset$Entry multiset$Entry : this.entrySet()) {
            if (Objects.equal(multiset$Entry.getElement(), o)) {
                return multiset$Entry.getCount();
            }
        }
        return 0;
    }
    
    @Override
    public boolean add(@Nullable final Object o) {
        this.add(o, 1);
        return true;
    }
    
    @Override
    public int add(@Nullable final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        return this.remove(o, 1) > 0;
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int setCount(@Nullable final Object o, final int n) {
        return Multisets.setCountImpl(this, o, n);
    }
    
    @Override
    public boolean setCount(@Nullable final Object o, final int n, final int n2) {
        return Multisets.setCountImpl(this, o, n, n2);
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        return Multisets.addAllImpl(this, collection);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return Multisets.removeAllImpl(this, collection);
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return Multisets.retainAllImpl(this, collection);
    }
    
    @Override
    public void clear() {
        Iterators.clear(this.entryIterator());
    }
    
    @Override
    public Set elementSet() {
        Set elementSet = this.elementSet;
        if (elementSet == null) {
            elementSet = (this.elementSet = this.createElementSet());
        }
        return elementSet;
    }
    
    Set createElementSet() {
        return new AbstractMultiset$ElementSet(this);
    }
    
    abstract Iterator entryIterator();
    
    abstract int distinctElements();
    
    @Override
    public Set entrySet() {
        Set entrySet = this.entrySet;
        if (entrySet == null) {
            entrySet = (this.entrySet = this.createEntrySet());
        }
        return entrySet;
    }
    
    Set createEntrySet() {
        return new AbstractMultiset$EntrySet(this);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Multisets.equalsImpl(this, o);
    }
    
    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }
    
    @Override
    public String toString() {
        return this.entrySet().toString();
    }
}
