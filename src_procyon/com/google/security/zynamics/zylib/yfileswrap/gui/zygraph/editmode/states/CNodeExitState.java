package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.c.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public final class CNodeExitState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final q m_node;
    
    public CNodeExitState(final CStateFactory factory, final AbstractZyGraph graph, final q node) {
        this.m_factory = factory;
        this.m_graph = graph;
        this.m_node = node;
    }
    
    public AbstractZyGraph getGraph() {
        return this.m_graph;
    }
    
    public q getNode() {
        return this.m_node;
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
        if (b.t()) {
            return CHitNodesTransformer.enterNode(this.m_factory, mouseEvent, b);
        }
        return CHitNodesTransformer.exitNode(this.m_factory, mouseEvent, b, this);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return CMousePressedHandler.handleMousePressed(this.m_factory, this, abstractZyGraph, mouseEvent);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
}
