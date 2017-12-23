package gui.panel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;
import java.util.List;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;

/**
 * Created by ${tianlin} on 2017-11-18.
 */
public class ReportPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance=new ReportPanel();

    public JLabel l=new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i= ChartUtil.getImage(rs,400,300);
        ImageIcon icon=new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
    }
    public static void main(String[] args){
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
