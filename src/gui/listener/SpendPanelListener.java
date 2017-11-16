package gui.listener;

import gui.panel.SpendPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${tianlin} on 2017-10-28.
 */
public class SpendPanelListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SpendPanel.instance.vAvgSpendPerDay.setText("xxxxx");
    }
}
