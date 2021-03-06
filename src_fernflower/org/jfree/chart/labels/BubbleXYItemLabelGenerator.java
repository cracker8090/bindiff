package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.ObjectUtilities;

public class BubbleXYItemLabelGenerator extends AbstractXYItemLabelGenerator implements Serializable, XYItemLabelGenerator {
   static final long serialVersionUID = -8458568928021240922L;
   public static final String DEFAULT_FORMAT_STRING = "{3}";
   private NumberFormat zFormat;
   private DateFormat zDateFormat;

   public BubbleXYItemLabelGenerator() {
      this("{3}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
   }

   public BubbleXYItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3, NumberFormat var4) {
      super(var1, var2, var3);
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'zFormat\' argument.");
      } else {
         this.zFormat = var4;
      }
   }

   public BubbleXYItemLabelGenerator(String var1, DateFormat var2, DateFormat var3, DateFormat var4) {
      super(var1, var2, var3);
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'zFormat\' argument.");
      } else {
         this.zDateFormat = var4;
      }
   }

   public NumberFormat getZFormat() {
      return this.zFormat;
   }

   public DateFormat getZDateFormat() {
      return this.zDateFormat;
   }

   public String generateLabel(XYDataset var1, int var2, int var3) {
      return this.generateLabelString(var1, var2, var3);
   }

   public String generateLabelString(XYDataset var1, int var2, int var3) {
      String var4 = null;
      Object[] var5 = null;
      if(var1 instanceof XYZDataset) {
         var5 = this.createItemArray((XYZDataset)var1, var2, var3);
      } else {
         var5 = this.createItemArray(var1, var2, var3);
      }

      var4 = MessageFormat.format(this.getFormatString(), var5);
      return var4;
   }

   protected Object[] createItemArray(XYZDataset var1, int var2, int var3) {
      Object[] var4 = new Object[4];
      var4[0] = var1.getSeriesKey(var2).toString();
      Number var5 = var1.getX(var2, var3);
      DateFormat var6 = this.getXDateFormat();
      if(var6 != null) {
         var4[1] = var6.format(var5);
      } else {
         var4[1] = this.getXFormat().format(var5);
      }

      Number var7 = var1.getY(var2, var3);
      DateFormat var8 = this.getYDateFormat();
      if(var8 != null) {
         var4[2] = var8.format(var7);
      } else {
         var4[2] = this.getYFormat().format(var7);
      }

      Number var9 = var1.getZ(var2, var3);
      if(this.zDateFormat != null) {
         var4[3] = this.zDateFormat.format(var9);
      } else {
         var4[3] = this.zFormat.format(var9);
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BubbleXYItemLabelGenerator)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         BubbleXYItemLabelGenerator var2 = (BubbleXYItemLabelGenerator)var1;
         return !ObjectUtilities.equal(this.zFormat, var2.zFormat)?false:ObjectUtilities.equal(this.zDateFormat, var2.zDateFormat);
      }
   }
}
