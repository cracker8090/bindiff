package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.SingleTreeNodeRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import javax.swing.border.EmptyBorder;

public class SingleCallGraphTree extends AbstractGraphNodeTree {
   private SingleGraph singleGraph;

   public SingleCallGraphTree(ViewTabPanelFunctions var1, Diff var2, ViewData var3, SingleGraph var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.singleGraph = (SingleGraph)Preconditions.checkNotNull(var4);
      Preconditions.checkNotNull(var5);
      Preconditions.checkNotNull(var6);
      Preconditions.checkNotNull(var7);
      this.createTree(var1, var2, var3, var5, var6, var7);
      this.setBorder(new EmptyBorder(1, 1, 1, 1));
      this.addListeners();
      this.expandRow(0);
   }

   private void createTree(ViewTabPanelFunctions var1, Diff var2, ViewData var3, TreeNodeSearcher var4, GraphNodeMultiFilter var5, TreeNodeMultiSorter var6) {
      SingleCallGraphRootTreeNode var7 = new SingleCallGraphRootTreeNode(var1, this, var2, var3, var4, var5, var6);
      this.setRootVisible(false);
      this.getModel().setRoot(var7);
      this.setCellRenderer(new SingleTreeNodeRenderer());
   }

   public void dispose() {
      super.dispose();
      this.singleGraph = null;
   }

   public SingleGraph getGraph() {
      return this.singleGraph;
   }
}
