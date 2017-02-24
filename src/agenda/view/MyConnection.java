/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.view;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author NOFFABEL
 */
public class MyConnection extends JFrame {
    static final int WIDTH = 450;
    static final int HEIGHT = 350;
    
    public static void main(String[] args) {
        MyConnection index = new MyConnection();
        index.setDefaultCloseOperation(EXIT_ON_CLOSE);
        index.setTitle("Page de Connexion.");
        index.setVisible(true);
        index.setSize(WIDTH, HEIGHT);
    }
    
}
