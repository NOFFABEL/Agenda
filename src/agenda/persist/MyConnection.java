/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NOFFABEL
 */
public class MyConnection {
    //Propriété de la classe nécessaire à la connexion
    
    //URL  de connexion
    final static String url = "jdbc:mysql://localhost/agenda?autoReconnect=false&useSSL=false";
    
    //Nom de l'utilisateur
    final static String user = "root";
    
    //Mot de passe de l'utilisateur
    final static String password = "";
    
    //Objet de la connexion
    static Connection sqlConnection;
    
    //Méthode de classe
   
    /**
     * Méthode qui va retourner notre instance 
     * et la créer si elle n'existe pas
     * @return Connection
     */
    public static Connection getInstance(){
        if(sqlConnection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Drive OK");
                
                sqlConnection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection effective");
                //JOptionPane.showMessageDialog(null, "MyConnection réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION", JOptionPane.ERROR_MESSAGE);
            }
        }
       return sqlConnection;
    }
}

