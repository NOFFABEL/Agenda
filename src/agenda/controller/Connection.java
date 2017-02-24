/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.controller;

import javax.swing.JFrame;

/**
 *
 * @author NOFFABEL
 */
public class Connection extends JFrame {
    static final int WIDTH = 200;
    static final int HEIGHT = 200;
    
    public static void main(String[] args) {
        Connection index = new Connection();
        index.setDefaultCloseOperation(EXIT_ON_CLOSE);
        index.setTitle("Page de Connexion.");
        index.setVisible(true);
        index.setSize(200, 200);
    }
    
}