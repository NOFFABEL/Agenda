/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author NOFFABEL
 */
public class TextField extends JComponent implements Fields {
    
    boolean isEmpty;
    boolean require;
    
    String str_name, str_label, str_error;
    JLabel lbl_error, lbl_text;
    JTextField tfd_text;
    GridBagLayout grid;
    
    /**
     * 
     * @param name
     * @param req 
     */
    public TextField(String name, boolean req) {
                
        isEmpty = true;
        require = req;
        
        str_error = "bnnb";
        str_name = str_label = name;
        
        if(require) {
            str_label = "* " + str_label;
        }
        
        str_label += " : ";
        
        initComponent();
    }
    
    private void initComponent() {
        grid = new GridBagLayout();
        setLayout(grid);
        
        GridBagConstraints c = new GridBagConstraints();
        c.ipady = c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.weighty = 4;
        
        lbl_text = new JLabel(str_label);
        c.gridy = 0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.insets = new Insets(2, 10, 0, 2);
        add(lbl_text, c);
        
        tfd_text = new JTextField();
        c.gridwidth = 3;
        c.insets = new Insets(2, -50, 1, 10);
        add(tfd_text, c);
        
        lbl_error = new JLabel(str_error);
        lbl_error.setFont(new Font("Time New Roman", 1, 10));
        lbl_error.setForeground(Color.RED);
        c.gridy = 3;
        c.gridx = 1;
        c.gridheight = 1;
        c.insets = new Insets(0, 1, 5, 10);
        add(lbl_error, c);
    }
    
    public TextField(String name) {
        this(name, false);
    }
    
    @Override
    public boolean isValidField() {
        check();
        return !(require & isEmpty);
    }
    
    @Override
    public void buildError() {
        str_error = "Le champ " + str_name + " ne doit pas être vide. remplissez le avant de valider.";
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
    
    @SuppressWarnings("")
    public String getValue() {
        try {
            return tfd_text.getText();
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
