/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

import java.awt.Color;
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
     * TODO: 
     * 
     * @param name
     * @param req 
     */
    public DateField(String name, boolean req) {
        
        super();
        grid = new GridBagLayout();
        super.setLayout(grid);
        
        isEmpty = true;
        require = req;
        
        str_error = "";
        str_name = name;
        str_label = name;
        
        if(require){
            str_label = "* " + str_label;
        }
        
        str_label += " : ";
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        
        lbl_text = new JLabel(str_label);
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.insets = new Insets(2, 10, 0, 2);
        super.add(lbl_text, c);
        
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
        c.weightx = 4;
        c.gridy = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(2, 0, 1, 10);
        super.add(tfd_text, c);
        
        lbl_error = new JLabel(str_error);
        lbl_error.setFont(new Font("Time New Roman", 1, 10));
        lbl_error.setForeground(Color.RED);
        c.gridx = 1;
        c.gridheight = 1;
        c.insets = new Insets(0, 1, 5, 10);
        super.add(lbl_error, c);
        
        lbl_error.setVisible(false);
    }
    
    public DateField(String name) {
        this(name, false);
    }
    
    @Override
    public boolean isValidField() {
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
            System.err.println("Une exception de la classe " + e.getClass() + " a été retourné la cause est - " + e.getCause() + " - "
                    + "\nVoici le message de l'exception - " + e.getMessage() + " -.");
            return "";
        }
    }
    
    @Override
    public boolean isRequired() {
        return this.require;
    }
}
