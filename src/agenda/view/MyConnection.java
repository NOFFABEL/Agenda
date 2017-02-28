/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view;

import agenda.view.form.PasswordField;
import agenda.view.form.TextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author NOFFABEL
 */
public class MyConnection extends JFrame {
    static final int MY_WIDTH = 450;
    static final int MY_HEIGHT = 350;
    
    TextField login;
    PasswordField password;
    GridBagLayout grid;
    ScrollPane pane;
    JButton btn_ok;
    
    public MyConnection() {
        super();
        pane = new ScrollPane();
        
        int y = MY_HEIGHT/3;
        
        login = new TextField("Login", true);
        password = new PasswordField("Password", true);
        btn_ok = new JButton("Connexion");
        grid = new GridBagLayout();
        
        login.setSize(MY_WIDTH, y);
        password.setSize(MY_WIDTH, y);
        btn_ok.setSize(MY_WIDTH, y);
        
        super.setLayout(grid);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        //c.ipady = 10;
        c.weightx = 3;
        c.gridx = 0;
        c.gridy = 0;
        //c.gridwidth = 3;
        //c.gridheight = 2;
        pane.add(login, c);
        
        c.gridy = 1;
        pane.add(password, c);
        
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        //pane.add(btn_ok,c);
        
        super.setTitle("Connexion");
        super.setContentPane(pane);
        super.pack();
        super.setSize(MY_WIDTH, MY_HEIGHT);
    }
    
    private void initComponents() {
        
    }
    
    public static void main(String[] args) {
        MyConnection index = new MyConnection();
        index.setDefaultCloseOperation(EXIT_ON_CLOSE);
        index.setVisible(true);
    }
}
