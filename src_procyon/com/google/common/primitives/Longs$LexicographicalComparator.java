package com.google.common.primitives;

import java.util.*;

enum Longs$LexicographicalComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    private Longs$LexicographicalComparator(final String s, final int n) {
    }
    
    public int compare(final long[] array, final long[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            final int compare = Longs.compare(array[i], array2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return array.length - array2.length;
    }
}
