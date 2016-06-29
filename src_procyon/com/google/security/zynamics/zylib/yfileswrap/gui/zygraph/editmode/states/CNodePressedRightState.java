package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.awt.event.*;
import y.c.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CNodePressedRightState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final MouseEvent m_event;
    private final q m_node;
    
    public CNodePressedRightState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final q q, final MouseEvent mouseEvent) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_node = (q)Preconditions.checkNotNull(q, (Object)"Error: node argument can not be null");
        this.m_event = (MouseEvent)Preconditions.checkNotNull(mouseEvent, (Object)"Error: event argument can not be null");
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
        if (CNodeMover.isDraggedFar(this.m_event.getX(), this.m_event.getY(), mouseEvent.getX(), mouseEvent.getY())) {
            return new CStateChange(this.m_factory.createBackgroundDraggedRightState(mouseEvent), true);
        }
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createNodeClickedRightState(this.m_node, mouseEvent), true);
    }
}
