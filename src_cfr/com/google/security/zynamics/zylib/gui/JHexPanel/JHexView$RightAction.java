/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class JHexView$RightAction
extends AbstractAction {
    private static final long serialVersionUID = 3857972387525998636L;
    final /* synthetic */ JHexView this$0;

    private JHexView$RightAction(JHexView jHexView) {
        this.this$0 = jHexView;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JHexView.access$1000(this.this$0, actionEvent, JHexView.access$2300(this.this$0) == JHexView$Views.HEX_VIEW ? 1 : 2);
    }

    /* synthetic */ JHexView$RightAction(JHexView jHexView, JHexView$1 jHexView$1) {
        this(jHexView);
    }
}

