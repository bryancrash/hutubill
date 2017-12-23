package gui.panel;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by ${tianlin} on 2017-11-17.
 */
public class RecordPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();
    JLabel lSpend=new JLabel("话费（￥)");
    JLabel lCategory=new JLabel("分类");
    JLabel lComment=new JLabel("备注");
    JLabel IDate=new JLabel("日期");

    public JTextField tfSpend=new JTextField("0");
    public CategoryComboBoxModel cbModel=new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory=new JComboBox<>(cbModel);
    public JTextField tfComment=new JTextField();
    public JXDatePicker datepick=new JXDatePicker(new Date());

    JButton bSubmit=new JButton("记一笔");

    public RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,IDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(IDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        addListener();
    }

    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }

    @Override
    public void updateData() {
        cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    private void resetInput() {
        tfSpend.setText("0");
        tfComment.setText("");
        if(0!=cbModel.cs.size()){
            cbCategory.setSelectedIndex(0);
        }
        datepick.setDate(new Date());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        bSubmit.addActionListener(listener);
    }

}
