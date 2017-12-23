package gui.panel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * Created by ${tianlin} on 2017-11-18.
 */
public class RecoverPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance=new RecoverPanel();

    JButton bRecover=new JButton("恢复");

    public RecoverPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bRecover);
        this.add(bRecover);
        addListener();
    }

    public void addListener(){
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }
    public static void main(String[] args){
        GUIUtil.showPanel(RecoverPanel.instance);
    }
}
