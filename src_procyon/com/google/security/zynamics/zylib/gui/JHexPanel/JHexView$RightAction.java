package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import com.google.common.base.*;

class JHexView$RightAction extends AbstractAction
{
    private static final long serialVersionUID = 3857972387525998636L;
    final /* synthetic */ JHexView this$0;
    
    private JHexView$RightAction(final JHexView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.changeBy(actionEvent, (this.this$0.m_activeView == JHexView$Views.HEX_VIEW) ? 1 : 2);
    }
}
