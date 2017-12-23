package gui.panel;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ${tianlin} on 2017-11-18.
 */
public class ConfigPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static ConfigPanel instance=new ConfigPanel();
    JLabel IBudget=new JLabel("本月预算（￥）");
    public JTextField tfBudget=new JTextField("0");

    JLabel IMysql=new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath=new JTextField("");
    JButton bSubmit=new JButton("更新");

    public ConfigPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,IBudget,IMysql);
        GUIUtil.setColor(ColorUtil.blueColor,bSubmit);

        JPanel pInput=new JPanel();
        JPanel pSubmit=new JPanel();
        int gap=40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));
        pInput.add(IBudget);
        pInput.add(tfBudget);
        pInput.add(IMysql);
        pInput.add(tfMysqlPath);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);
        
        addListener();
    }


    public void addListener() {
        ConfigListener l=new ConfigListener();
        bSubmit.addActionListener(l);
    }


    public void updateData(){
        String budget=new ConfigService().get(ConfigService.budget);
        String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
        tfBudget.setText(budget);
        tfMysqlPath.setText(mysqlPath);
        tfBudget.grabFocus();
    }

    public static void main(String[] args){
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}
