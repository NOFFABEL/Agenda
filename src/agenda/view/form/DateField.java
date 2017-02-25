/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.text.DateFormatter;
import org.jdatepicker.impl.*;

/**
 *
 * @author NOFFABEL
 */
public class DateField extends JComponent implements Fields {
    
    boolean isEmpty;
    boolean require;
    
    String str_name, str_label, str_error;
    JLabel lbl_error, lbl_text;
    JDatePickerImpl tfd_text;
    JDatePanelImpl date_panel;
    GridBagLayout grid;
    
    /**
     * 
     * @param name
     * @param req 
     */
    public DateField(String name, boolean req) {
        
        isEmpty = true;
        require = req;
        
        str_error = "";
        str_name = name;
        
        if(require)
            str_label = "* " + name;
        
        str_label += " : ";
        
        GridBagConstraints c = new GridBagConstraints();
        grid = new GridBagLayout();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        
        lbl_text = new JLabel(str_label);
        c.gridy = 0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.insets = new Insets(10, 10, 0, 10);
        grid.addLayoutComponent(lbl_text, c);
        
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        date_panel = new JDatePanelImpl(new UtilDateModel(), p);
        tfd_text = new JDatePickerImpl(date_panel, 
            new DateFormatter(
                DateFormat.getDateInstance(
                    DateFormat.SHORT, 
                        new Locale("fr","FR")
                )
            )
        );
        c.gridy = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(10, 2, 1, 10);
        grid.addLayoutComponent(tfd_text, c);
        
        lbl_error = new JLabel(str_error);
        lbl_error.setFont(new Font("Time New Roman", 1, 10));
        lbl_error.setForeground(Color.RED);
        c.gridx = 1;
        c.gridheight = 1;
        c.insets = new Insets(0, 5, 10, 10);
        grid.addLayoutComponent(lbl_error, c);
        
        lbl_error.setVisible(false);
        
        grid.layoutContainer((Container) this);
    }
    
    @Override
    public boolean isValid() {
        check();
        return !(require & isEmpty);
    }
    
    @Override
    public void buildError() {
        str_error = str_name + " ne doit pas être vide. remplissez le avant de valider.";
        setError(true);
    }

    @Override
    public void setError(boolean bln) {
        if(bln) {
            date_panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else {
            date_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        lbl_error.setVisible(bln);
    }
    
    @Override
    public void check() {
        isEmpty = getValue().isEmpty();
    }
    
    public String getValue() {
        try {
            return tfd_text.getJFormattedTextField().getText();
        }catch(Exception e) {
            return "";
        }
    }
}
