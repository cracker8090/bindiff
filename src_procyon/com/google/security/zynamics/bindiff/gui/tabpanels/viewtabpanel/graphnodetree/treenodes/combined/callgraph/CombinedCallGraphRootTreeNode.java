package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import javax.swing.tree.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.*;

public class CombinedCallGraphRootTreeNode extends AbstractRootTreeNode
{
    private CombinedGraph graph;
    
    public CombinedCallGraphRootTreeNode(final ViewTabPanelFunctions viewTabPanelFunctions, final AbstractGraphNodeTree abstractGraphNodeTree, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        super(viewTabPanelFunctions, abstractGraphNodeTree, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.graph = (CombinedGraph)abstractGraphNodeTree.getGraph();
        this.createChildren();
    }
    
    @Override
    protected void delete() {
        super.delete();
        this.graph = null;
    }
    
    @Override
    public void createChildren() {
        this.add(new CombinedCallGraphBaseTreeNode(this));
    }
    
    public CombinedGraph getGraph() {
        return this.graph;
    }
    
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public CombinedCallGraphRootTreeNode getRootNode() {
        return this;
    }
    
    @Override
    public ESide getSide() {
        return null;
    }
    
    @Override
    public void handleMouseEvent(final MouseEvent mouseEvent) {
    }
    
    @Override
    public String toString() {
        return "Root Node";
    }
}
