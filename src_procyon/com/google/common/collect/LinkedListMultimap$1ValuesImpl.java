package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$1ValuesImpl extends AbstractSequentialList
{
    final /* synthetic */ LinkedListMultimap this$0;
    
    LinkedListMultimap$1ValuesImpl(final LinkedListMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.size;
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        final LinkedListMultimap$NodeIterator linkedListMultimap$NodeIterator = new LinkedListMultimap$NodeIterator(this.this$0, n);
        return new LinkedListMultimap$1ValuesImpl$1(this, linkedListMultimap$NodeIterator, linkedListMultimap$NodeIterator);
    }
}
