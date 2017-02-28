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
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author NOFFABEL
 */
public class PhoneField extends JComponent implements Fields {
    
    boolean isEmpty;
    boolean require;
    
    String str_name, str_label, str_error;
    JLabel lbl_error, lbl_text;
    JFormattedTextField tfd_text;
    GridBagLayout grid;
    
    /**
     * 
     * @param name
     * @param req 
     */
    public PhoneField(String name, boolean req) {
        
        super();
        grid = new GridBagLayout();
        super.setLayout(grid);
        
        isEmpty = true;
        require = req;
        
        str_error = "";
        str_name = name;
        
        if(require) {
            str_label = "* " + name;
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
        
        
        tfd_text = new JFormattedTextField();
        c.weightx = 3;
        c.gridy = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(0, 1, 5, 10);
        super.add(tfd_text, c);
        
        lbl_error = new JLabel(str_error);
        lbl_error.setFont(new Font("Time New Roman", 1, 10));
        lbl_error.setForeground(Color.RED);
        c.gridx = 1;
        c.gridheight = 1;
        c.insets = new Insets(0, 5, 10, 10);
        super.add(lbl_error, c);
        
        lbl_error.setVisible(false);
    }
    
    public PhoneField(String name) {
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
            tfd_text.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else {
            tfd_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        lbl_error.setVisible(bln);
    }
    
    @Override
    public void check() {
        isEmpty = getValue().isEmpty();
    }
    
    public String getValue() {
        try{
            return tfd_text.getText();
        }catch(Exception e){
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
