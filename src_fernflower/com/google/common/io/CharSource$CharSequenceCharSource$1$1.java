package com.google.common.io;

import com.google.common.collect.AbstractIterator;
import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1;
import java.util.Iterator;

class CharSource$CharSequenceCharSource$1$1 extends AbstractIterator {
   Iterator lines;
   // $FF: synthetic field
   final CharSource$CharSequenceCharSource$1 this$1;

   CharSource$CharSequenceCharSource$1$1(CharSource$CharSequenceCharSource$1 var1) {
      this.this$1 = var1;
      this.lines = CharSource$CharSequenceCharSource.access$200().split(CharSource$CharSequenceCharSource.access$100(this.this$1.this$0)).iterator();
   }

   protected String computeNext() {
      if(this.lines.hasNext()) {
         String var1 = (String)this.lines.next();
         if(this.lines.hasNext() || !var1.isEmpty()) {
            return var1;
         }
      }

      return (String)this.endOfData();
   }
}
