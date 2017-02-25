/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view;

import agenda.view.form.DateField;
import agenda.view.form.Form;
import agenda.view.form.PasswordField;
import agenda.view.form.TextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author NOFFABEL
 */
public class TestFields extends JFrame implements Form{
    
    TextField field1;
    PasswordField field2;
    DateField field3;
    GridBagLayout grid;
    JRootPane pane;
    
    /**
     * 
     */
    public TestFields() {
        field1 = new TextField("Nom", true);
        field1.setVisible(true);
        field2 = new PasswordField("Password", true);
        field2.setVisible(true);
        field3 = new DateField("Date", true);
        field3.setVisible(true);
        
        pane = new JRootPane();
        
        grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        
        grid.addLayoutComponent(field1, c);
        grid.addLayoutComponent(field2, c);
        grid.addLayoutComponent(field3, c);
        
        grid.layoutContainer(pane);
        
        add(pane);
    }
    
    /**
     * 
     * @param args 
     */
    public void main( String[] args) {
        /*TestFields fen = new TestFields();
        fen.setSize(460, 280);
        fen.pack();
        fen.setVisible(true);*/
        
        JTextField field0 = new JTextField();
        add(field0);
        setSize(460, 280);
        pack();
        setVisible(true);
    }

    @Override
    public void buildErrors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
