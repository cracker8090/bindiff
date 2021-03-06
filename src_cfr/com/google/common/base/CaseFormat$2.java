/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CharMatcher;

final class CaseFormat$2
extends CaseFormat {
    CaseFormat$2(String string2, int n3, CharMatcher charMatcher, String string3) {
        super(string, n2, (CharMatcher)((Object)string2), (String)n3, null);
    }

    @Override
    String normalizeWord(String string) {
        return Ascii.toLowerCase(string);
    }

    @Override
    String convert(CaseFormat caseFormat, String string) {
        if (caseFormat == LOWER_HYPHEN) {
            return string.replace('_', '-');
        }
        if (caseFormat != UPPER_UNDERSCORE) return super.convert(caseFormat, string);
        return Ascii.toUpperCase(string);
    }
}

