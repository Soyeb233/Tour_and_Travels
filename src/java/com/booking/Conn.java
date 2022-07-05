/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booking;

import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conn 
{
   
          java.sql.Connection con;java.sql.Statement st;
  public Conn()
  {
     
        
         try 
         {    
         Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travels","root","");
          st=con.createStatement();
         System.out.println("Connection established");
         }
         catch(SQLException e)
         {
            System.out.println(e.getMessage()+" Sql Exception");
         }
         catch(NullPointerException e)
         {
             System.out.println(e.getMessage()+" Null value");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
         }   
          
     
     
  }
  public static void main(String args[])
  {
      Conn c=new Conn();
  }
}
