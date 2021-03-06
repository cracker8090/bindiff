/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class PercentageThreeBarIcon
implements Icon {
    private final String leftText;
    private final String centerText;
    private final String rightText;
    private final int leftValue;
    private final int centerValue;
    private final int rightValue;
    private int width;
    private final int height;
    private final int xOffset;
    private final int yOffset;
    private final Color leftBarColor;
    private final Color centerBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;
    private final Color selectionColor;
    private final boolean selected;

    public PercentageThreeBarIcon(PercentageThreeBarCellData percentageThreeBarCellData, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, boolean bl2, int n2, int n3, int n4, int n5) {
        if (percentageThreeBarCellData.getLeftBarValue() == 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() == 0) {
            this.leftText = "";
            this.centerText = "";
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = 1;
            this.rightValue = 0;
            this.selected = bl2;
            this.width = n4;
            this.height = n5;
            this.xOffset = n2;
            this.yOffset = n3;
            this.leftBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.centerBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.rightBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.emptyBarColor = AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR;
            this.textColor = color5;
            this.selectionColor = color6;
            return;
        }
        if (percentageThreeBarCellData.getLeftBarValue() != 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() == 0) {
            this.leftText = "";
            this.centerText = Integer.toString(percentageThreeBarCellData.getLeftBarValue());
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = percentageThreeBarCellData.getLeftBarValue();
            this.rightValue = 0;
            this.selected = bl2;
            this.width = n4;
            this.height = n5;
            this.xOffset = n2;
            this.yOffset = n3;
            this.leftBarColor = color;
            this.centerBarColor = color;
            this.rightBarColor = color;
            this.emptyBarColor = color4;
            this.textColor = color5;
            this.selectionColor = color6;
            return;
        }
        if (percentageThreeBarCellData.getLeftBarValue() == 0 && percentageThreeBarCellData.getCenterBarValue() == 0 && percentageThreeBarCellData.getRightBarValue() != 0) {
            this.leftText = "";
            this.centerText = Integer.toString(percentageThreeBarCellData.getRightBarValue());
            this.rightText = "";
            this.leftValue = 0;
            this.centerValue = percentageThreeBarCellData.getRightBarValue();
            this.rightValue = 0;
            this.selected = bl2;
            this.width = n4;
            this.height = n5;
            this.xOffset = n2;
            this.yOffset = n3;
            this.leftBarColor = color3;
            this.centerBarColor = color3;
            this.rightBarColor = color3;
            this.emptyBarColor = color4;
            this.textColor = color5;
            this.selectionColor = color6;
            return;
        }
        this.leftText = Integer.toString(percentageThreeBarCellData.getLeftBarValue());
        this.centerText = Integer.toString(percentageThreeBarCellData.getCenterBarValue());
        this.rightText = Integer.toString(percentageThreeBarCellData.getRightBarValue());
        this.leftValue = percentageThreeBarCellData.getLeftBarValue();
        this.centerValue = percentageThreeBarCellData.getCenterBarValue();
        this.rightValue = percentageThreeBarCellData.getRightBarValue();
        this.selected = bl2;
        this.width = n4;
        this.height = n5;
        this.xOffset = n2;
        this.yOffset = n3;
        this.leftBarColor = color;
        this.centerBarColor = color2;
        this.rightBarColor = color3;
        this.emptyBarColor = color4;
        this.textColor = color5;
        this.selectionColor = color6;
    }

    private void drawText(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.leftText, graphics2D);
        Rectangle2D rectangle2D2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.centerText, graphics2D);
        Rectangle2D rectangle2D3 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds(this.rightText, graphics2D);
        double d2 = 4.0 + rectangle2D.getWidth() + 5.0 + rectangle2D2.getWidth() + 5.0 + rectangle2D3.getWidth() + 4.0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = (int)(((double)this.height - rectangle2D2.getHeight()) / 2.0 + rectangle2D2.getHeight()) - 1;
        if (d2 < (double)this.width) {
            n2 = 4;
            n3 = (int)(((double)this.width - rectangle2D2.getWidth()) / 2.0) + 1;
            n4 = (int)((double)this.width - rectangle2D3.getWidth() - 4.0);
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.leftText, n2, n5);
            graphics2D.drawString(this.centerText, n3, n5);
            graphics2D.drawString(this.rightText, n4, n5);
        } else {
            String string = "...";
            rectangle2D2 = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("...", graphics2D);
            n3 = (int)(((double)this.width - rectangle2D2.getWidth()) / 2.0) + 1;
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString("...", n3, n5);
        }
        graphics2D.setComposite(composite);
        graphics2D.setColor(color);
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        int n4 = n2 + this.xOffset;
        int n5 = n3 + this.yOffset;
        graphics.translate(n4, n5);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Color color = graphics2D.getColor();
        int n6 = this.leftValue + this.centerValue + this.rightValue;
        int n7 = 0;
        int n8 = 0;
        if (n6 != 0) {
            int n9 = 0;
            if (this.leftValue != 0) {
                n7 = (this.width - 2) * this.leftValue / n6;
                graphics2D.setColor(this.leftBarColor);
                graphics2D.fillRect(n4, n5, (double)(this.centerValue + this.rightValue) == 0.0 ? this.width : n7, this.height);
                if (n7 > 1) {
                    ++n9;
                }
            }
            if (this.centerValue != 0) {
                n8 = (this.width - 1) * this.centerValue / n6;
                graphics2D.setColor(this.centerBarColor);
                graphics2D.fillRect(n4 + n7 + n9, n5, (double)this.rightValue == 0.0 ? this.width - n7 - n9 : n8, this.height);
                if (n8 > 1) {
                    ++n9;
                }
            }
            if (this.rightValue != 0) {
                graphics2D.setColor(this.rightBarColor);
                graphics2D.fillRect(n4 + n7 + n8 + n9, n5, this.width - n7 - n8 - n9, this.height);
            }
            if (this.selected) {
                graphics2D.setColor(this.selectionColor);
                graphics2D.drawRect(n4, n5, this.width, this.height);
                Composite composite = graphics2D.getComposite();
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.fillRect(n4, n5, this.width, this.height);
                graphics2D.setComposite(composite);
            } else {
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawRect(n4, n5, this.width, this.height);
            }
            this.drawText(graphics2D);
        } else {
            graphics2D.setColor(this.emptyBarColor);
            graphics2D.fillRect(n4 + 1, n5 + 1, this.width - 1, this.height - 1);
            if (this.selected) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.6f));
                graphics2D.setColor(this.selectionColor);
                graphics2D.fillRect(n4, n5, this.width, this.height);
                graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
                graphics2D.drawRect(n4, n5, this.width, this.height);
            }
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
            Rectangle2D rectangle2D = graphics2D.getFontMetrics(graphics2D.getFont()).getStringBounds("0", graphics2D);
            int n10 = (int)(((double)this.width - rectangle2D.getWidth()) / 2.0) + 1;
            int n11 = (int)(((double)this.height - rectangle2D.getHeight()) / 2.0 + rectangle2D.getHeight()) - 1;
            graphics2D.setColor(this.textColor);
            graphics2D.drawString(this.centerText, n10, n11);
            graphics2D.setComposite(composite);
        }
        graphics2D.setColor(color);
        graphics.translate(- n4, - n5);
    }

    public void setWidth(int n2) {
        this.width = n2;
    }
}

