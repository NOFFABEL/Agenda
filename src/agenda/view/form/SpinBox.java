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
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author NOFFABEL
 */
public class SpinBox extends JComponent implements Fields {
    
    boolean isEmpty;
    boolean require;
    boolean isValid;
    
    String str_name, str_label, str_error;
    JLabel lbl_error, lbl_text;
    JSpinner spn_text;
    GridBagLayout grid;
    
    /**
     *
     * @param name
     * @param req
     */
    public SpinBox(String name, boolean req) {
        
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
        
        
        spn_text = new JSpinner(new SpinnerNumberModel(1,1,999,1));
        c.gridy = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(10, 2, 1, 10);
        grid.addLayoutComponent(spn_text, c);
        
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
        return !((require & isEmpty) || (require & !isEmpty & !isValid));
    }
    
    @Override
    public void buildError() {
        if(isEmpty) {
            str_error = str_name + " ne doit pas être vide. remplissez le avant de valider.";
            setError(true);
        } else if (!isValid) {
            str_error = str_name + " doit être un entier > 0.";
        }
    }

    @Override
    public void setError(boolean bln) {
        if(bln) {
            spn_text.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else {
            spn_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        lbl_error.setVisible(bln);
    }
    
    @Override
    public void check() {
        isValid = (spn_text.getValue() instanceof Integer);
        isEmpty = (getSpinValue() == 0);
    }
    
    public int getSpinValue() {
        return (int)spn_text.getValue();
    }
}
