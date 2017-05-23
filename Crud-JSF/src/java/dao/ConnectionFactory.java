/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author opereira
 */
public class ConnectionFactory {
    public static Connection getConnection(){
       
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
           return DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro: "+ e.getMessage());
            return null;
        }
    }
}
