/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view.form;

import agenda.view.form.TextField;
import javax.swing.JFrame;

/**
 *
 * @author NOFFABEL
 */
public class Test {
    
    public Test(){
        
    }
    
    public static void main( String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        
        TextField field0;
        field0 = new TextField("Nom");
        PasswordField pwd = new PasswordField("Password", true);
        MailField mail = new MailField("EMail", true);
        DateField date = new DateField("Date Naissance", true);
        f.add(field0);
        //f.add(pwd);
        //f.add(mail);
        //f.add(date);
        f.setSize(200, 100);
        f.setVisible(true);
    }
    
}
