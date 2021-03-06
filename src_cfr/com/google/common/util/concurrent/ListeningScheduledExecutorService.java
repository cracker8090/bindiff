/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Beta
public interface ListeningScheduledExecutorService
extends ListeningExecutorService,
ScheduledExecutorService {
    public ListenableScheduledFuture schedule(Runnable var1, long var2, TimeUnit var4);

    public ListenableScheduledFuture schedule(Callable var1, long var2, TimeUnit var4);

    public ListenableScheduledFuture scheduleAtFixedRate(Runnable var1, long var2, long var4, TimeUnit var6);

    public ListenableScheduledFuture scheduleWithFixedDelay(Runnable var1, long var2, long var4, TimeUnit var6);
}

