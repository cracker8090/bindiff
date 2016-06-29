package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class PinNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -3787089953079863373L;
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final GeneralPath generalPath = new GeneralPath();
        final int n2 = (int)rectangle2D.getMinY();
        final int n3 = (int)rectangle2D.getMaxY();
        final int n4 = (int)(rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0);
        int n5 = (int)(rectangle2D.getWidth() / 10.0);
        if (n5 < 2) {
            n5 = 2;
        }
        generalPath.moveTo(n4 - n5, n3 - n5);
        generalPath.lineTo(n4 + n5, n3 - n5);
        generalPath.lineTo(n4, n2 + n5);
        generalPath.closePath();
        final int n6 = 4 * n5;
        final Area area = new Area(new Ellipse2D.Double(n4 - n6 / 2, rectangle2D.getMaxY() - n6, n6, n6));
        area.add(new Area(generalPath));
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            area.transform(this.getTransform());
        }
        this.defaultDisplay(graphics2D, area);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof PinNeedle && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
