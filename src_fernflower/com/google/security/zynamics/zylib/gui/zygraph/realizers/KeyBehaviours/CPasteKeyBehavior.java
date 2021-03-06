package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import java.awt.Point;

public class CPasteKeyBehavior extends CAbstractKeyBehavior {
   private int m_caretX = 0;
   private int m_caretY = 0;
   private boolean m_isAboveComment;
   private boolean m_isLabelComment;
   private boolean m_isBehindComment;
   private IZyEditableObject m_editableObject;
   private boolean m_wasUneditableSelection;

   public CPasteKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
      int var1 = this.getCaretEndPosX();
      int var2 = this.getCaretMouseReleasedY();
      ZyLineContent var3 = this.getLineContent(var2);
      IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
      boolean var5 = false;
      String var6 = "";
      this.m_isAboveComment = this.isAboveLineComment(var2);
      this.m_isLabelComment = this.isLabelComment(var2);
      if(var1 == var3.getText().length() && !this.isComment(var1, var2)) {
         this.m_isBehindComment = true;
         var5 = true;
         var4 = var3.getLineObject();
      } else {
         this.m_isBehindComment = this.isBehindLineComment(var1, var2);
      }

      this.m_editableObject = var4;
      if(var4 != null) {
         if(!var5) {
            var6 = var3.getText().substring(var4.getStart(), var4.getEnd());
            if(this.isComment(var1, var2)) {
               var6 = this.getMultiLineComment(var2);
            }
         }

         this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), var4, var6, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
      }

   }

   protected void updateCaret() {
      this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
      if(this.m_wasUneditableSelection) {
         this.m_caretX = this.getCaretEndPosX();
         this.m_caretY = this.getCaretMouseReleasedY();
      } else {
         Point var1 = this.pasteClipboardText();
         this.m_caretX = var1.x;
         this.m_caretY = var1.y;
      }
   }

   protected void updateSelection() {
      this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
      this.deleteSelection();
   }

   protected void updateUndoHistory() {
      if(this.m_editableObject != null) {
         int var1 = this.getCaretEndPosX();
         int var2 = this.getCaretMouseReleasedY();
         ZyLineContent var3 = this.getLineContent(var2);
         IZyEditableObject var4 = var3.getLineFragmentObjectAt(var1);
         if(var4 != null) {
            String var5 = var3.getText().substring(var4.getStart(), var4.getEnd());
            if(this.isComment(var1, var2)) {
               var5 = this.getMultiLineComment(var2);
            }

            this.udpateUndolist(this.getLabelContent(), var3.getLineObject().getPersistentModel(), var4, var5, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
         }
      }

   }
}
