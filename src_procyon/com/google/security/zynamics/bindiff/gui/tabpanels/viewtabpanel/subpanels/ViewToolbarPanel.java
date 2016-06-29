package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ViewToolbarPanel extends JPanel
{
    private static final String ICONPATH = "data/toolbaricons/";
    private static final Icon DEFAULT_WINDOW_LAYOUT_UP;
    private static final Icon DEFAULT_WINDOW_LAYOUT_HOVER;
    private static final Icon DEFAULT_WINDOW_LAYOUT_DOWN;
    private static final Icon VIEW_MODE_NORMAL_UP;
    private static final Icon VIEW_MODE_NORMAL_HOVER;
    private static final Icon VIEW_MODE_NORMAL_DOWN;
    private static final Icon VIEW_MODE_COMBINED_UP;
    private static final Icon VIEW_MODE_COMBINED_HOVER;
    private static final Icon VIEW_MODE_COMBINED_DOWN;
    private static final Icon HIERARCHIC_LAYOUT_UP;
    private static final Icon HIERARCHIC_LAYOUT_HOVER;
    private static final Icon HIERARCHIC_LAYOUT_DOWN;
    private static final Icon ORTHOGONAL_LAYOUT_UP;
    private static final Icon ORTHOGONAL_LAYOUT_HOVER;
    private static final Icon ORTHOGONAL_LAYOUT_DOWN;
    private static final Icon CIRCULAR_LAYOUT_UP;
    private static final Icon CIRCULAR_LAYOUT_HOVER;
    private static final Icon CIRCULAR_LAYOUT_DOWN;
    private static final Icon AUTOLAYOUT_ON_UP;
    private static final Icon AUTOLAYOUT_ON_HOVER;
    private static final Icon AUTOLAYOUT_ON_DOWN;
    private static final Icon AUTOLAYOUT_OFF_UP;
    private static final Icon AUTOLAYOUT_OFF_HOVER;
    private static final Icon AUTOLAYOUT_OFF_DOWN;
    private static final Icon PROXIMITY_BROWSING_ON_UP;
    private static final Icon PROXIMITY_BROWSING_ON_HOVER;
    private static final Icon PROXIMITY_BROWSING_ON_DOWN;
    private static final Icon PROXIMITY_BROWSING_OFF_UP;
    private static final Icon PROXIMITY_BROWSING_OFF_HOVER;
    private static final Icon PROXIMITY_BROWSING_OFF_DOWN;
    private static final Icon PROXIMITY_FREEZE_ON_UP;
    private static final Icon PROXIMITY_FREEZE_ON_HOVER;
    private static final Icon PROXIMITY_FREEZE_ON_DOWN;
    private static final Icon PROXIMITY_FREEZE_OFF_UP;
    private static final Icon PROXIMITY_FREEZE_OFF_HOVER;
    private static final Icon PROXIMITY_FREEZE_OFF_DOWN;
    private static final Icon PROXIMITY_FREEZE_ON_UP_GRAY;
    private static final Icon PROXIMITY_FREEZE_ON_HOVER_GRAY;
    private static final Icon PROXIMITY_FREEZE_ON_DOWN_GRAY;
    private static final Icon PROXIMITY_FREEZE_OFF_UP_GRAY;
    private static final Icon PROXIMITY_FREEZE_OFF_HOVER_GRAY;
    private static final Icon PROXIMITY_FREEZE_OFF_DOWN_GRAY;
    private static final Icon SELECT_ANCESTORS_UP;
    private static final Icon SELECT_ANCESTORS_HOVER;
    private static final Icon SELECT_ANCESTORS_DOWN;
    private static final Icon SELECT_SUCCESSORS_UP;
    private static final Icon SELECT_SUCCESSORS_HOVER;
    private static final Icon SELECT_SUCCESSORS_DOWN;
    private static final Icon INVERT_SELECTION_UP;
    private static final Icon INVERT_SELECTION_HOVER;
    private static final Icon INVERT_SELECTION_DOWN;
    private static final Icon SELECT_BY_CRITERIA_UP;
    private static final Icon SELECT_BY_CRITERIA_HOVER;
    private static final Icon SELECT_BY_CRITERIA_DOWN;
    private static final Icon FIT_GRAPH_CONTENT_UP;
    private static final Icon FIT_GRAPH_CONTENT_HOVER;
    private static final Icon FIT_GRAPH_CONTENT_DOWN;
    private static final Icon ZOOM_TO_SELECTED_UP;
    private static final Icon ZOOM_TO_SELECTED_HOVER;
    private static final Icon ZOOM_TO_SELECTED_DOWN;
    private static final Icon SYNC_GRAPHS_ON_UP;
    private static final Icon SYNC_GRAPHS_ON_HOVER;
    private static final Icon SYNC_GRAPHS_ON_DOWN;
    private static final Icon SYNC_GRAPHS_OFF_UP;
    private static final Icon SYNC_GRAPHS_OFF_HOVER;
    private static final Icon SYNC_GRAPHS_OFF_DOWN;
    private static final Icon ICON_OPTIONS;
    private ViewToolbarPanel$InternalSettingsListener settingsListener;
    private ViewToolbarPanel$InternalSearchButtonsListener buttonListener;
    private final GraphSearchField searchField;
    private final GraphSearchOptionsDialog searchOptionsDialog;
    private final SearchResultsDialog searchResultsDialog;
    private ViewTabPanelFunctions controller;
    private GraphSettings settings;
    private final JButton clearSearchResultsButton;
    private final JButton searchOptionsButton;
    private final JButton graphSyncButton;
    private final JToolBar groupSave;
    private final JToolBar groupView;
    private final JToolBar groupLayout;
    private final JToolBar groupModes;
    private final JToolBar groupSelection;
    private final JToolBar groupFitContent;
    
    public ViewToolbarPanel(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super(new BorderLayout());
        this.settingsListener = new ViewToolbarPanel$InternalSettingsListener(this, null);
        this.buttonListener = new ViewToolbarPanel$InternalSearchButtonsListener(this);
        this.clearSearchResultsButton = new JButton();
        this.searchOptionsButton = new JButton(ViewToolbarPanel.ICON_OPTIONS);
        this.graphSyncButton = new JButton();
        this.groupSave = new JToolBar();
        this.groupView = new JToolBar();
        this.groupLayout = new JToolBar();
        this.groupModes = new JToolBar();
        this.groupSelection = new JToolBar();
        this.groupFitContent = new JToolBar();
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.settings = viewTabPanelFunctions.getGraphSettings();
        this.searchField = new GraphSearchField(viewTabPanelFunctions, this.clearSearchResultsButton);
        this.searchResultsDialog = new SearchResultsDialog(viewTabPanelFunctions.getMainWindow(), this.searchField);
        this.searchOptionsDialog = new GraphSearchOptionsDialog(viewTabPanelFunctions.getMainWindow(), viewTabPanelFunctions.getGraphs().getCombinedGraph());
        this.clearSearchResultsButton.addActionListener(this.buttonListener);
        this.searchOptionsButton.addActionListener(this.buttonListener);
        this.settings.addListener(this.settingsListener);
        this.groupSave.setFloatable(false);
        this.groupView.setFloatable(false);
        this.groupLayout.setFloatable(false);
        this.groupModes.setFloatable(false);
        this.groupSelection.setFloatable(false);
        this.groupFitContent.setFloatable(false);
        this.groupSave.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
        this.groupView.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
        this.groupLayout.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
        this.groupSelection.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
        this.groupFitContent.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY)));
        this.groupModes.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY)));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        final JButton add = this.groupSave.add(new ResetDefaultViewLayoutAction(viewTabPanelFunctions));
        add.setMargin(new Insets(0, 0, 0, 0));
        add.setRolloverEnabled(true);
        add.setIcon(ViewToolbarPanel.DEFAULT_WINDOW_LAYOUT_UP);
        add.setRolloverIcon(ViewToolbarPanel.DEFAULT_WINDOW_LAYOUT_HOVER);
        add.setPressedIcon(ViewToolbarPanel.DEFAULT_WINDOW_LAYOUT_DOWN);
        add.setToolTipText("Reset default Window Layout");
        final JButton add2 = this.groupView.add(new SwitchToNormalViewModeAction(viewTabPanelFunctions));
        add2.setMargin(new Insets(0, 0, 0, 0));
        add2.setRolloverEnabled(true);
        add2.setIcon((this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) ? ViewToolbarPanel.VIEW_MODE_NORMAL_UP : ViewToolbarPanel.VIEW_MODE_NORMAL_UP);
        add2.setRolloverIcon((this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) ? ViewToolbarPanel.VIEW_MODE_NORMAL_HOVER : ViewToolbarPanel.VIEW_MODE_NORMAL_HOVER);
        add2.setPressedIcon((this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) ? ViewToolbarPanel.VIEW_MODE_NORMAL_DOWN : ViewToolbarPanel.VIEW_MODE_NORMAL_DOWN);
        add2.setToolTipText("Switch to Normal View Mode");
        final JButton add3 = this.groupView.add(new SwitchToCombinedViewModeAction(viewTabPanelFunctions));
        add3.setMargin(new Insets(0, 0, 0, 0));
        add3.setRolloverEnabled(true);
        add3.setIcon((this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) ? ViewToolbarPanel.VIEW_MODE_COMBINED_UP : ViewToolbarPanel.VIEW_MODE_COMBINED_UP);
        add3.setRolloverIcon((this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) ? ViewToolbarPanel.VIEW_MODE_COMBINED_HOVER : ViewToolbarPanel.VIEW_MODE_COMBINED_HOVER);
        add3.setPressedIcon((this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) ? ViewToolbarPanel.VIEW_MODE_COMBINED_DOWN : ViewToolbarPanel.VIEW_MODE_COMBINED_DOWN);
        add3.setToolTipText("Switch to Combined View Mode");
        final JButton add4 = this.groupLayout.add(new HierarchicalGraphLayoutAction(viewTabPanelFunctions));
        add4.setMargin(new Insets(0, 0, 0, 0));
        add4.setRolloverEnabled(true);
        add4.setIcon(ViewToolbarPanel.HIERARCHIC_LAYOUT_UP);
        add4.setRolloverIcon(ViewToolbarPanel.HIERARCHIC_LAYOUT_HOVER);
        add4.setPressedIcon(ViewToolbarPanel.HIERARCHIC_LAYOUT_DOWN);
        add4.setToolTipText("Switch to Hierarchical Layout");
        final JButton add5 = this.groupLayout.add(new OrthogonalGraphLayoutAction(viewTabPanelFunctions));
        add5.setMargin(new Insets(0, 0, 0, 0));
        add5.setRolloverEnabled(true);
        add5.setIcon(ViewToolbarPanel.ORTHOGONAL_LAYOUT_UP);
        add5.setRolloverIcon(ViewToolbarPanel.ORTHOGONAL_LAYOUT_HOVER);
        add5.setPressedIcon(ViewToolbarPanel.ORTHOGONAL_LAYOUT_DOWN);
        add5.setToolTipText("Switch to Orthogonal Layout");
        final JButton add6 = this.groupLayout.add(new CircularGraphLayoutAction(viewTabPanelFunctions));
        add6.setMargin(new Insets(0, 0, 0, 0));
        add6.setRolloverEnabled(true);
        add6.setIcon(ViewToolbarPanel.CIRCULAR_LAYOUT_UP);
        add6.setRolloverIcon(ViewToolbarPanel.CIRCULAR_LAYOUT_HOVER);
        add6.setPressedIcon(ViewToolbarPanel.CIRCULAR_LAYOUT_DOWN);
        add6.setToolTipText("Switch to Circlular Layout");
        final boolean automaticLayouting = this.settings.getLayoutSettings().getAutomaticLayouting();
        final JButton add7 = this.groupModes.add(new ToggleAutomaticLayoutAction(viewTabPanelFunctions));
        add7.setMargin(new Insets(0, 0, 0, 0));
        add7.setRolloverEnabled(true);
        add7.setIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_UP : ViewToolbarPanel.AUTOLAYOUT_OFF_UP);
        add7.setRolloverIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_HOVER : ViewToolbarPanel.AUTOLAYOUT_OFF_HOVER);
        add7.setPressedIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_DOWN : ViewToolbarPanel.AUTOLAYOUT_OFF_DOWN);
        add7.setToolTipText("Toogle Autolayout");
        final boolean proximityBrowsing = this.settings.getProximitySettings().getProximityBrowsing();
        final JButton add8 = this.groupModes.add(new ToggleProximityBrowsingAction(viewTabPanelFunctions));
        add8.setMargin(new Insets(0, 0, 0, 0));
        add8.setRolloverEnabled(true);
        add8.setIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_UP : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_UP);
        add8.setRolloverIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_HOVER : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_HOVER);
        add8.setPressedIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_DOWN : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_DOWN);
        add8.setToolTipText("Toogle Proximity Browsing");
        final boolean proximityBrowsingFrozen = this.settings.getProximitySettings().getProximityBrowsingFrozen();
        final JButton add9 = this.groupModes.add(new ToggleProximityFreezeModeAction(viewTabPanelFunctions));
        add9.setMargin(new Insets(0, 0, 0, 0));
        add9.setRolloverEnabled(true);
        if (proximityBrowsing) {
            add9.setIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_UP : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_UP);
            add9.setRolloverIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_HOVER : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_HOVER);
            add9.setPressedIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_DOWN : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_DOWN);
        }
        else {
            add9.setIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_UP_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_UP_GRAY);
            add9.setRolloverIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_HOVER_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_HOVER_GRAY);
            add9.setPressedIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_DOWN_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_DOWN_GRAY);
        }
        add9.setToolTipText("Toogle Proximity Freeze");
        final JButton add10 = this.groupSelection.add(new SelectByCriteriaAction(viewTabPanelFunctions));
        add10.setMargin(new Insets(0, 0, 0, 0));
        add10.setRolloverEnabled(true);
        add10.setIcon(ViewToolbarPanel.SELECT_BY_CRITERIA_UP);
        add10.setRolloverIcon(ViewToolbarPanel.SELECT_BY_CRITERIA_HOVER);
        add10.setPressedIcon(ViewToolbarPanel.SELECT_BY_CRITERIA_DOWN);
        add10.setToolTipText("Select by Criteria");
        final JButton add11 = this.groupSelection.add(new SelectAncestorsAction(viewTabPanelFunctions));
        add11.setMargin(new Insets(0, 0, 0, 0));
        add11.setRolloverEnabled(true);
        add11.setIcon(ViewToolbarPanel.SELECT_ANCESTORS_UP);
        add11.setRolloverIcon(ViewToolbarPanel.SELECT_ANCESTORS_HOVER);
        add11.setPressedIcon(ViewToolbarPanel.SELECT_ANCESTORS_DOWN);
        add11.setToolTipText("Select Ancestors");
        final JButton add12 = this.groupSelection.add(new SelectSuccessorsAction(viewTabPanelFunctions));
        add12.setMargin(new Insets(0, 0, 0, 0));
        add12.setRolloverEnabled(true);
        add12.setIcon(ViewToolbarPanel.SELECT_SUCCESSORS_UP);
        add12.setRolloverIcon(ViewToolbarPanel.SELECT_SUCCESSORS_HOVER);
        add12.setPressedIcon(ViewToolbarPanel.SELECT_SUCCESSORS_DOWN);
        add12.setToolTipText("Select Successors");
        if (Toolkit.getDefaultToolkit().getScreenSize().getWidth() > 1024.0) {
            final JButton add13 = this.groupSelection.add(new InverseSelectionAction(viewTabPanelFunctions));
            add13.setMargin(new Insets(0, 0, 0, 0));
            add13.setRolloverEnabled(true);
            add13.setIcon(ViewToolbarPanel.INVERT_SELECTION_UP);
            add13.setRolloverIcon(ViewToolbarPanel.INVERT_SELECTION_HOVER);
            add13.setPressedIcon(ViewToolbarPanel.INVERT_SELECTION_DOWN);
            add13.setToolTipText("Invert Selection");
        }
        final JButton add14 = this.groupFitContent.add(new FitGraphContentAction(viewTabPanelFunctions));
        add14.setMargin(new Insets(0, 0, 0, 0));
        add14.setRolloverEnabled(true);
        add14.setIcon(ViewToolbarPanel.FIT_GRAPH_CONTENT_UP);
        add14.setRolloverIcon(ViewToolbarPanel.FIT_GRAPH_CONTENT_HOVER);
        add14.setPressedIcon(ViewToolbarPanel.FIT_GRAPH_CONTENT_DOWN);
        add14.setToolTipText("Fit Graph Content");
        final JButton add15 = this.groupFitContent.add(new ZoomToSelectedAction(viewTabPanelFunctions));
        add15.setMargin(new Insets(0, 0, 0, 0));
        add15.setRolloverEnabled(true);
        add15.setIcon(ViewToolbarPanel.ZOOM_TO_SELECTED_UP);
        add15.setRolloverIcon(ViewToolbarPanel.ZOOM_TO_SELECTED_HOVER);
        add15.setPressedIcon(ViewToolbarPanel.ZOOM_TO_SELECTED_DOWN);
        add15.setToolTipText("Zoom to selected Nodes");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.groupSave, "West");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.groupView, "West");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(this.groupLayout, "West");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(this.groupFitContent, "West");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.add(this.groupSelection, "West");
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel6.add(this.groupModes, "West");
        panel.add(panel2, "Center");
        panel2.add(panel3, "Center");
        panel3.add(panel4, "Center");
        panel4.add(panel5, "Center");
        panel5.add(panel6, "Center");
        panel6.add(this.createRightToolbarPanel());
        this.add(panel, "Center");
    }
    
    private JPanel createRightToolbarPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
        panel.add(this.createSyncPanel(), "West");
        panel.add(this.createSearchPanel(), "Center");
        return panel;
    }
    
    private JPanel createSearchPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 25));
        this.searchField.setPreferredSize(new Dimension(this.getPreferredSize().width, 20));
        this.searchField.setBackground(Color.WHITE);
        final JButton button = new JButton(new ShowSearchResultsDialogAction(this.controller));
        button.setText("Results");
        button.setBackground(Color.WHITE);
        button.setFocusable(false);
        this.clearSearchResultsButton.setToolTipText("Clear Search Results");
        this.clearSearchResultsButton.setFocusable(false);
        this.clearSearchResultsButton.setBackground(Color.WHITE);
        this.clearSearchResultsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
        this.searchOptionsButton.setToolTipText("Search Settings");
        this.searchOptionsButton.setFocusable(false);
        this.searchOptionsButton.setBackground(Color.WHITE);
        this.searchOptionsButton.setPreferredSize(new Dimension(32, this.clearSearchResultsButton.getPreferredSize().height));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(0, 1, 0, 1));
        panel2.add(this.searchOptionsButton, "Center");
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(this.clearSearchResultsButton, "Center");
        panel3.add(panel2, "East");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(0, 1, 0, 0));
        panel4.add(button, "Center");
        panel4.add(panel3, "West");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel5.add(this.searchField, "Center");
        panel5.add(panel4, "East");
        panel.add(panel5, "Center");
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBorder(new EmptyBorder(6, 10, 6, 5));
        panel6.add(panel, "Center");
        return panel6;
    }
    
    private JPanel createSyncPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        this.graphSyncButton.addActionListener(new ToggleGraphSynchronizationAction(this.controller));
        this.graphSyncButton.setMargin(new Insets(0, 0, 0, 0));
        this.graphSyncButton.setBorderPainted(false);
        this.graphSyncButton.setContentAreaFilled(false);
        this.graphSyncButton.setFocusable(false);
        this.graphSyncButton.setRolloverEnabled(true);
        this.graphSyncButton.setIcon(this.settings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_ON_UP : ViewToolbarPanel.SYNC_GRAPHS_OFF_UP);
        this.graphSyncButton.setRolloverIcon(this.settings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_ON_HOVER : ViewToolbarPanel.SYNC_GRAPHS_OFF_HOVER);
        this.graphSyncButton.setPressedIcon(this.settings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_OFF_DOWN : ViewToolbarPanel.SYNC_GRAPHS_ON_DOWN);
        this.graphSyncButton.setToolTipText("Toogle Graph Synchronization");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel2.add(this.graphSyncButton, "Center");
        panel.add(new JLabel("  Sync"), "West");
        panel.add(panel2, "Center");
        return panel;
    }
    
    public void dispose() {
        this.clearSearchResultsButton.removeActionListener(this.buttonListener);
        this.searchOptionsButton.removeActionListener(this.buttonListener);
        this.settings.removeListener(this.settingsListener);
        this.searchField.dispose();
        this.searchResultsDialog.dispose();
        this.searchOptionsDialog.dispose();
        this.settingsListener = null;
        this.buttonListener = null;
        this.controller = null;
        this.settings = null;
    }
    
    public SearchResultsDialog getSearchResultsDialog() {
        return this.searchResultsDialog;
    }
    
    public void setCaretIntoJumpToAddressField(final ESide caretIntoJumpToAddressField) {
        this.searchField.setCaretIntoJumpToAddressField(caretIntoJumpToAddressField);
    }
    
    public void setCaretIntoSearchField() {
        this.searchField.setCaretIntoSearchField();
    }
    
    static {
        DEFAULT_WINDOW_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_up.png");
        DEFAULT_WINDOW_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_hover.png");
        DEFAULT_WINDOW_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/default_window_layout_down.png");
        VIEW_MODE_NORMAL_UP = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_up.png");
        VIEW_MODE_NORMAL_HOVER = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_hover.png");
        VIEW_MODE_NORMAL_DOWN = ImageUtils.getImageIcon("data/toolbaricons/view_mode_normal_down.png");
        VIEW_MODE_COMBINED_UP = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_up.png");
        VIEW_MODE_COMBINED_HOVER = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_hover.png");
        VIEW_MODE_COMBINED_DOWN = ImageUtils.getImageIcon("data/toolbaricons/view_mode_combined_down.png");
        HIERARCHIC_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_up.png");
        HIERARCHIC_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_hover.png");
        HIERARCHIC_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/hierarchic_layout_down.png");
        ORTHOGONAL_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_up.png");
        ORTHOGONAL_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_hover.png");
        ORTHOGONAL_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/orthogonal_layout_down.png");
        CIRCULAR_LAYOUT_UP = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_up.png");
        CIRCULAR_LAYOUT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_hover.png");
        CIRCULAR_LAYOUT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/circular_layout_down.png");
        AUTOLAYOUT_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_up.png");
        AUTOLAYOUT_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_hover.png");
        AUTOLAYOUT_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/autolayout_on_down.png");
        AUTOLAYOUT_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_up.png");
        AUTOLAYOUT_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_hover.png");
        AUTOLAYOUT_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/autolayout_off_down.png");
        PROXIMITY_BROWSING_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_up.png");
        PROXIMITY_BROWSING_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_hover.png");
        PROXIMITY_BROWSING_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_on_down.png");
        PROXIMITY_BROWSING_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_up.png");
        PROXIMITY_BROWSING_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_hover.png");
        PROXIMITY_BROWSING_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_off_down.png");
        PROXIMITY_FREEZE_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_up.png");
        PROXIMITY_FREEZE_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_hover.png");
        PROXIMITY_FREEZE_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_down.png");
        PROXIMITY_FREEZE_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_up.png");
        PROXIMITY_FREEZE_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_hover.png");
        PROXIMITY_FREEZE_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_down.png");
        PROXIMITY_FREEZE_ON_UP_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_up_gray.png");
        PROXIMITY_FREEZE_ON_HOVER_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_hover_gray.png");
        PROXIMITY_FREEZE_ON_DOWN_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_on_down_gray.png");
        PROXIMITY_FREEZE_OFF_UP_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_up_gray.png");
        PROXIMITY_FREEZE_OFF_HOVER_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_hover_gray.png");
        PROXIMITY_FREEZE_OFF_DOWN_GRAY = ImageUtils.getImageIcon("data/toolbaricons/proximity_browsing_freeze_off_down_gray.png");
        SELECT_ANCESTORS_UP = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_up.png");
        SELECT_ANCESTORS_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_hover.png");
        SELECT_ANCESTORS_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_ancestors_down.png");
        SELECT_SUCCESSORS_UP = ImageUtils.getImageIcon("data/toolbaricons/select_successors_up.png");
        SELECT_SUCCESSORS_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_successors_hover.png");
        SELECT_SUCCESSORS_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_successors_down.png");
        INVERT_SELECTION_UP = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_up.png");
        INVERT_SELECTION_HOVER = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_hover.png");
        INVERT_SELECTION_DOWN = ImageUtils.getImageIcon("data/toolbaricons/invert_selection_down.png");
        SELECT_BY_CRITERIA_UP = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_up.png");
        SELECT_BY_CRITERIA_HOVER = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_hover.png");
        SELECT_BY_CRITERIA_DOWN = ImageUtils.getImageIcon("data/toolbaricons/select_by_criteria_down.png");
        FIT_GRAPH_CONTENT_UP = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_up.png");
        FIT_GRAPH_CONTENT_HOVER = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_hover.png");
        FIT_GRAPH_CONTENT_DOWN = ImageUtils.getImageIcon("data/toolbaricons/fit_graph_to_panel_down.png");
        ZOOM_TO_SELECTED_UP = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_up.png");
        ZOOM_TO_SELECTED_HOVER = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_hover.png");
        ZOOM_TO_SELECTED_DOWN = ImageUtils.getImageIcon("data/toolbaricons/zoom_selected_down.png");
        SYNC_GRAPHS_ON_UP = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_up.png");
        SYNC_GRAPHS_ON_HOVER = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_hover.png");
        SYNC_GRAPHS_ON_DOWN = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_on_down.png");
        SYNC_GRAPHS_OFF_UP = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_up.png");
        SYNC_GRAPHS_OFF_HOVER = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_hover.png");
        SYNC_GRAPHS_OFF_DOWN = ImageUtils.getImageIcon("data/toolbaricons/synchron_graphs_off_down.png");
        ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
    }
}