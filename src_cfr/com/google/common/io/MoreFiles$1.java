/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Predicate;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;

final class MoreFiles$1
implements Predicate {
    final /* synthetic */ LinkOption[] val$optionsCopy;

    MoreFiles$1(LinkOption[] arrlinkOption) {
        this.val$optionsCopy = arrlinkOption;
    }

    public boolean apply(Path path) {
        return Files.isDirectory(path, this.val$optionsCopy);
    }

    public String toString() {
        String string = String.valueOf(Arrays.toString(this.val$optionsCopy));
        return new StringBuilder(23 + String.valueOf(string).length()).append("MoreFiles.isDirectory(").append(string).append(")").toString();
    }
}

