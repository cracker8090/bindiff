package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import org.jfree.data.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.resources.*;
import org.jfree.chart.labels.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

class BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter
{
    final /* synthetic */ BasicBlockMatchesPie3dPanel this$0;
    
    private BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(final BasicBlockMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void basicblocksCountChanged() {
        this.this$0.updateDataset();
    }
}
