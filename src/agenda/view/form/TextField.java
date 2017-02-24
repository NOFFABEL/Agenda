/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author NOFFABEL
 */
public class TextField extends Container {
    String str_name, str_error;
    JLabel lbl_error, lbl_text;
    JTextField tfd_text;
    GroupLayout h_layout, v_layout;
    
    TextField(String name, int width, int height) {
        tfd_text = new JTextField();
        h_layout = new GroupLayout(this);
        v_layout = new GroupLayout(this);
        lbl_error = new JLabel();
        lbl_text = new JLabel(name);
        
        lbl_text.setSize(width/4, height/4);
        tfd_text.setSize(width*3/4, height*3/4);
        lbl_error.setSize(width*3/4, height*3/4);
        lbl_error.setVisible(false);
        h_layout.setAutoCreateContainerGaps(true);
        v_layout.setAutoCreateContainerGaps(true);
        
        v_layout.setVerticalGroup(
            v_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tfd_text, GroupLayout.Alignment.LEADING)
        );
        v_layout.setVerticalGroup(
            v_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lbl_error, GroupLayout.Alignment.LEADING)
        );
        h_layout.setHorizontalGroup(
            h_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lbl_text, GroupLayout.Alignment.LEADING)
        );
        h_layout.setHorizontalGroup(
            h_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tfd_text, GroupLayout.Alignment.LEADING)
        );
    }
    
    
}
