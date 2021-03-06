package com.google.common.base;

import java.util.*;

class CharMatcher$RangesMatcher extends CharMatcher
{
    private final String description;
    private final char[] rangeStarts;
    private final char[] rangeEnds;
    
    CharMatcher$RangesMatcher(final String description, final char[] rangeStarts, final char[] rangeEnds) {
        this.description = description;
        this.rangeStarts = rangeStarts;
        this.rangeEnds = rangeEnds;
        Preconditions.checkArgument(rangeStarts.length == rangeEnds.length);
        for (int i = 0; i < rangeStarts.length; ++i) {
            Preconditions.checkArgument(rangeStarts[i] <= rangeEnds[i]);
            if (i + 1 < rangeStarts.length) {
                Preconditions.checkArgument(rangeEnds[i] < rangeStarts[i + 1]);
            }
        }
    }
    
    @Override
    public boolean matches(final char c) {
        final int binarySearch = Arrays.binarySearch(this.rangeStarts, c);
        if (binarySearch >= 0) {
            return true;
        }
        final int n = ~binarySearch - 1;
        return n >= 0 && c <= this.rangeEnds[n];
    }
    
    @Override
    public String toString() {
        return this.description;
    }
}
