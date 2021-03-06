package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible
public abstract class UnmodifiableIterator implements Iterator
{
    @Deprecated
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
