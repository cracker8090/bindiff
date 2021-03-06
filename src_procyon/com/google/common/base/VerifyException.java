package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Beta
@GwtCompatible
public class VerifyException extends RuntimeException
{
    public VerifyException() {
    }
    
    public VerifyException(@Nullable final String s) {
        super(s);
    }
    
    public VerifyException(@Nullable final Throwable t) {
        super(t);
    }
    
    public VerifyException(@Nullable final String s, @Nullable final Throwable t) {
        super(s, t);
    }
}
