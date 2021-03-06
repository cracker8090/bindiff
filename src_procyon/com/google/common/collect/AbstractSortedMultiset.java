package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
abstract class AbstractSortedMultiset extends AbstractMultiset implements SortedMultiset
{
    @GwtTransient
    final Comparator comparator;
    private transient SortedMultiset descendingMultiset;
    
    AbstractSortedMultiset() {
        this(Ordering.natural());
    }
    
    AbstractSortedMultiset(final Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }
    
    @Override
    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }
    
    @Override
    NavigableSet createElementSet() {
        return new SortedMultisets$NavigableElementSet(this);
    }
    
    @Override
    public Comparator comparator() {
        return this.comparator;
    }
    
    @Override
    public Multiset$Entry firstEntry() {
        final Iterator entryIterator = this.entryIterator();
        return entryIterator.hasNext() ? entryIterator.next() : null;
    }
    
    @Override
    public Multiset$Entry lastEntry() {
        final Iterator descendingEntryIterator = this.descendingEntryIterator();
        return descendingEntryIterator.hasNext() ? descendingEntryIterator.next() : null;
    }
    
    @Override
    public Multiset$Entry pollFirstEntry() {
        final Iterator entryIterator = this.entryIterator();
        if (entryIterator.hasNext()) {
            final Multiset$Entry multiset$Entry = entryIterator.next();
            final Multiset$Entry immutableEntry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
            entryIterator.remove();
            return immutableEntry;
        }
        return null;
    }
    
    @Override
    public Multiset$Entry pollLastEntry() {
        final Iterator descendingEntryIterator = this.descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            final Multiset$Entry multiset$Entry = descendingEntryIterator.next();
            final Multiset$Entry immutableEntry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
            descendingEntryIterator.remove();
            return immutableEntry;
        }
        return null;
    }
    
    @Override
    public SortedMultiset subMultiset(@Nullable final Object o, final BoundType boundType, @Nullable final Object o2, final BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return this.tailMultiset(o, boundType).headMultiset(o2, boundType2);
    }
    
    abstract Iterator descendingEntryIterator();
    
    Iterator descendingIterator() {
        return Multisets.iteratorImpl(this.descendingMultiset());
    }
    
    @Override
    public SortedMultiset descendingMultiset() {
        final SortedMultiset descendingMultiset = this.descendingMultiset;
        return (descendingMultiset == null) ? (this.descendingMultiset = this.createDescendingMultiset()) : descendingMultiset;
    }
    
    SortedMultiset createDescendingMultiset() {
        return new AbstractSortedMultiset$1DescendingMultisetImpl(this);
    }
}
