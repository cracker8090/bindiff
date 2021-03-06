/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class HierarchicalGraphLayoutAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;

    public HierarchicalGraphLayoutAction(ViewTabPanelFunctions viewTabPanelFunctions) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.doLayout(EGraphLayout.HIERARCHICAL);
    }
}

