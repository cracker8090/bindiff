package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.common.base.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.graph.*;

public class CombinedFlowGraphTree extends AbstractGraphNodeTree
{
    private CombinedGraph combinedGraph;
    
    public CombinedFlowGraphTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final CombinedGraph combinedGraph, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(treeNodeSearcher);
        Preconditions.checkNotNull(graphNodeMultiFilter);
        Preconditions.checkNotNull(treeNodeMultiSorter);
        this.combinedGraph = combinedGraph;
        this.createTree(viewTabPanelFunctions, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.addListeners();
        this.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.expandRow(0);
    }
    
    private void createTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        final CombinedFlowGraphRootTreeNode root = new CombinedFlowGraphRootTreeNode(viewTabPanelFunctions, this, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.setRootVisible(false);
        this.getModel().setRoot(root);
        this.setCellRenderer(new CombinedTreeNodeRenderer());
    }
    
    @Override
    public void dispose() {
        super.dispose();
        this.combinedGraph = null;
    }
    
    @Override
    public CombinedGraph getGraph() {
        return this.combinedGraph;
    }
}
