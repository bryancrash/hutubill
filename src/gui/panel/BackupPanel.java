package gui.panel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * Created by ${tianlin} on 2017-11-18.
 */
public class BackupPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance=new BackupPanel();
    JButton bBackup=new JButton("备份");

    public BackupPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bBackup);
        this.add(bBackup);
        addListener();
    }


    public void addListener(){
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }
    public static void main(String[] args){
        GUIUtil.showPanel(BackupPanel.instance);
    }
}
