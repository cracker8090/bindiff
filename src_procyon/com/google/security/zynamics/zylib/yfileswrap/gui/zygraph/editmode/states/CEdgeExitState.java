package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;

public class CEdgeExitState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final d m_edge;
    
    public CEdgeExitState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final d d) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_edge = (d)Preconditions.checkNotNull(d, (Object)"Error: edge argument can not be null");
    }
    
    public d getEdge() {
        return this.m_edge;
    }
    
    public AbstractZyGraph getGraph() {
        return this.m_graph;
    }
    
    @Override
    public CStateFactory getStateFactory() {
        return this.m_factory;
    }
    
    @Override
    public IMouseStateChange mouseDragged(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        final cW b = this.m_graph.getGraph().b(this.m_graph.getEditMode().translateX(mouseEvent.getX()), this.m_graph.getEditMode().translateY(mouseEvent.getY()));
        if (b.u()) {
            return CHitEdgesTransformer.changeEdge(this.m_factory, mouseEvent, b, this.m_edge);
        }
        return CHitEdgesTransformer.exitEdge(this.m_factory, mouseEvent, b, this);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
}
