/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.function;

import org.jfree.data.function.Function2D;

public class LineFunction2D
implements Function2D {
    private double a;
    private double b;

    public LineFunction2D(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    @Override
    public double getValue(double d2) {
        return this.a + this.b * d2;
    }
}

