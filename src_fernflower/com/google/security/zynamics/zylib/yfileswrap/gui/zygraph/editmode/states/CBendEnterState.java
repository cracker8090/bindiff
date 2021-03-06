package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.aA;
import y.h.cW;
import y.h.x;

public class CBendEnterState implements IMouseState {
   private final CStateFactory m_factory;
   private final AbstractZyGraph m_graph;
   private final x m_bend;

   public CBendEnterState(CStateFactory var1, AbstractZyGraph var2, x var3) {
      this.m_factory = (CStateFactory)Preconditions.checkNotNull(var1, "Error: factory argument can not be null");
      this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(var2, "Error: graph argument can not be null");
      this.m_bend = (x)Preconditions.checkNotNull(var3, "Error: b argument can not be null");
   }

   public x getBend() {
      return this.m_bend;
   }

   public AbstractZyGraph getGraph() {
      return this.m_graph;
   }

   public CStateFactory getStateFactory() {
      return this.m_factory;
   }

   public IMouseStateChange mouseDragged(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }

   public IMouseStateChange mouseMoved(MouseEvent var1, AbstractZyGraph var2) {
      double var3 = this.m_graph.getEditMode().translateX(var1.getX());
      double var5 = this.m_graph.getEditMode().translateY(var1.getY());
      cW var7 = this.m_graph.getGraph().b(var3, var5);
      if(var7.t()) {
         this.m_factory.createBendExitState(this.m_bend, var1);
         return CHitNodesTransformer.enterNode(this.m_factory, var1, var7);
      } else if(var7.s()) {
         throw new IllegalStateException();
      } else if(var7.u()) {
         d var9 = var7.k();
         this.m_factory.createBendExitState(this.m_bend, var1);
         return new CStateChange(this.m_factory.createEdgeEnterState(var9, var1), true);
      } else if(var7.r()) {
         aA var8 = var7.m();
         this.m_factory.createBendExitState(this.m_bend, var1);
         return new CStateChange(this.m_factory.createEdgeLabelEnterState(var8, var1), true);
      } else {
         return var7.v()?CHitBendsTransformer.changeBend(this.m_factory, var1, var7, this.m_bend):(var7.q()?new CStateChange(this, true):new CStateChange(this.m_factory.createBendExitState(this.m_bend, var1), true));
      }
   }

   public IMouseStateChange mousePressed(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }

   public IMouseStateChange mouseReleased(MouseEvent var1, AbstractZyGraph var2) {
      return new CStateChange(this.m_factory.createDefaultState(), true);
   }
}
