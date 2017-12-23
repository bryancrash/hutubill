package gui.panel;

import javax.swing.*;

/**
 * Created by ${tianlin} on 2017-11-28.
 */
public abstract class WorkingPanel extends JPanel{
    public abstract void updateData();
    public abstract void addListener();
}
