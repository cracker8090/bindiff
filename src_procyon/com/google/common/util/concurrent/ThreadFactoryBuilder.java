package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public final class ThreadFactoryBuilder
{
    private String nameFormat;
    private Boolean daemon;
    private Integer priority;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private ThreadFactory backingThreadFactory;
    
    public ThreadFactoryBuilder() {
        this.nameFormat = null;
        this.daemon = null;
        this.priority = null;
        this.uncaughtExceptionHandler = null;
        this.backingThreadFactory = null;
    }
    
    public ThreadFactoryBuilder setNameFormat(final String nameFormat) {
        format(nameFormat, 0);
        this.nameFormat = nameFormat;
        return this;
    }
    
    public ThreadFactoryBuilder setDaemon(final boolean b) {
        this.daemon = b;
        return this;
    }
    
    public ThreadFactoryBuilder setPriority(final int n) {
        Preconditions.checkArgument(n >= 1, "Thread priority (%s) must be >= %s", n, 1);
        Preconditions.checkArgument(n <= 10, "Thread priority (%s) must be <= %s", n, 10);
        this.priority = n;
        return this;
    }
    
    public ThreadFactoryBuilder setUncaughtExceptionHandler(final Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
    
    public ThreadFactoryBuilder setThreadFactory(final ThreadFactory threadFactory) {
        this.backingThreadFactory = (ThreadFactory)Preconditions.checkNotNull(threadFactory);
        return this;
    }
    
    public ThreadFactory build() {
        return build(this);
    }
    
    private static ThreadFactory build(final ThreadFactoryBuilder threadFactoryBuilder) {
        final String nameFormat = threadFactoryBuilder.nameFormat;
        return new ThreadFactoryBuilder$1((threadFactoryBuilder.backingThreadFactory != null) ? threadFactoryBuilder.backingThreadFactory : Executors.defaultThreadFactory(), nameFormat, (nameFormat != null) ? new AtomicLong(0L) : null, threadFactoryBuilder.daemon, threadFactoryBuilder.priority, threadFactoryBuilder.uncaughtExceptionHandler);
    }
    
    private static String format(final String s, final Object... array) {
        return String.format(Locale.ROOT, s, array);
    }
}
