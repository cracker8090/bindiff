package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
@GwtCompatible
public final class Runnables
{
    private static final Runnable EMPTY_RUNNABLE;
    
    public static Runnable doNothing() {
        return Runnables.EMPTY_RUNNABLE;
    }
    
    static {
        EMPTY_RUNNABLE = new Runnables$1();
    }
}
