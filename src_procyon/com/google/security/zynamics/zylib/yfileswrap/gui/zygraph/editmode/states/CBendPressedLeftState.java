package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.h.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CBendPressedLeftState implements IMouseState
{
    private final CStateFactory m_factory;
    private final AbstractZyGraph m_graph;
    private final x m_bend;
    
    public CBendPressedLeftState(final CStateFactory cStateFactory, final AbstractZyGraph abstractZyGraph, final x x) {
        this.m_factory = (CStateFactory)Preconditions.checkNotNull(cStateFactory, (Object)"Error: factory argument can not be null");
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: graph argument can not be null");
        this.m_bend = (x)Preconditions.checkNotNull(x, (Object)"Error: bend argument can not be null");
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
        return new CStateChange(this, true);
    }
    
    @Override
    public IMouseStateChange mouseMoved(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mousePressed(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createDefaultState(), true);
    }
    
    @Override
    public IMouseStateChange mouseReleased(final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph) {
        return new CStateChange(this.m_factory.createBendClickedLeftState(this.m_bend, mouseEvent), false);
    }
}
