package com.google.common.cache;

import java.security.*;
import sun.misc.*;
import java.lang.reflect.*;

final class Striped64$1 implements PrivilegedExceptionAction
{
    @Override
    public Unsafe run() {
        final Class<Unsafe> clazz = Unsafe.class;
        for (final Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            final Object value = field.get(null);
            if (clazz.isInstance(value)) {
                return clazz.cast(value);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}
