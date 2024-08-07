/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;
import java.sql.Connection;
import java.sql.DriverManager;
//import.java.sql.Statement;
/**
 * 
 *
 * @author Alok Kumar
 */
public class DBconnection {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","*******");
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return con;
    }
     
    
}
