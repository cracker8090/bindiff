/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.AbstractAction;

class SelectionHistoryTreeGroupNode$4
extends AbstractAction {
    final /* synthetic */ SelectionHistoryTreeGroupNode this$0;

    SelectionHistoryTreeGroupNode$4(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode, String string) {
        this.this$0 = selectionHistoryTreeGroupNode;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = SelectionHistoryTreeGroupNode.access$100(this.this$0).getCombinedGraphSelection().iterator();
        do {
            if (!iterator.hasNext()) {
                ClipboardHelpers.copyToClipboard(stringBuilder.toString());
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            RawFunction rawFunction = (RawFunction)combinedDiffNode.getPrimaryRawNode();
            if (rawFunction == null) continue;
            stringBuilder.append(rawFunction.getAddress().toHexString());
            stringBuilder.append("\n");
        } while (true);
    }
}

