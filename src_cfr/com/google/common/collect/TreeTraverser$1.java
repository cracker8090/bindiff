/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class TreeTraverser$1
extends FluentIterable {
    final /* synthetic */ Object val$root;
    final /* synthetic */ TreeTraverser this$0;

    TreeTraverser$1(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.val$root = object;
    }

    public UnmodifiableIterator iterator() {
        return this.this$0.preOrderIterator(this.val$root);
    }
}

