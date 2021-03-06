/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.ForwardingObject;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMapEntry
extends ForwardingObject
implements Map.Entry {
    protected ForwardingMapEntry() {
    }

    @Override
    protected abstract Map.Entry delegate();

    public Object getKey() {
        return this.delegate().getKey();
    }

    public Object getValue() {
        return this.delegate().getValue();
    }

    public Object setValue(Object object) {
        return this.delegate().setValue(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return this.delegate().equals(object);
    }

    @Override
    public int hashCode() {
        return this.delegate().hashCode();
    }

    protected boolean standardEquals(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!Objects.equal(this.getKey(), entry.getKey())) return false;
        if (!Objects.equal(this.getValue(), entry.getValue())) return false;
        return true;
    }

    protected int standardHashCode() {
        int n2;
        Object object = this.getKey();
        Object object2 = this.getValue();
        int n3 = object == null ? 0 : object.hashCode();
        if (object2 == null) {
            n2 = 0;
            return n3 ^ n2;
        }
        n2 = object2.hashCode();
        return n3 ^ n2;
    }

    @Beta
    protected String standardToString() {
        String string = String.valueOf(this.getKey());
        String string2 = String.valueOf(this.getValue());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("=").append(string2).toString();
    }
}

