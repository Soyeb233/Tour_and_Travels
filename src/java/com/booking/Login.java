/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booking;

/**
 *
 * @author soyeb
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet
{
    Statement st;
    Connection con;
     public void doGet(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException
     {
         
         
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         String email=req.getParameter("email");
         String password=req.getParameter("password");
       //  out.println("<h2>username "+username+" </h2>");
         
         try
         {
             
             Conn c=new Conn();
             st=c.con.createStatement();
             String sql="select  * from peopledetail where mail=? and password=?;";
          PreparedStatement pst=c.con.prepareStatement(sql);
          pst.setString(1,email);
          pst.setString(2,password);
             
            
             ResultSet result=pst.executeQuery();
             boolean flag=false;
             while(result.next())
             {
                 String userMail=result.getString("mail");
                 String pwd=result.getString("password");
                 if(email.equals(userMail))
                 {
                     flag=true;
                        if(password.equals(pwd))
                        {
                            flag=true;
                             //  out.println("<h2> <font color='Greend'>  Validates Successfully   </font> </h2>");
                        }
                        else 
                        {
                            flag=false;
                        }
                        
                 }
                 else 
                 {
                      flag=false;
                 }
                 
             }
             if(flag==true)
             {
                   out.println("<h2> <font color='Green'>  Validates Successfully   </font> </h2>");
                   out.println("<A HREF=\"http://www.google.com\">link</A>");
                  
                
                   /*
                   String url = "/Menu.html";
                   ServletContext context = getServletContext();
                   RequestDispatcher dispatcher = context.getRequestDispatcher(toDo);
dispatcher.forward(req, res);

    */
                      RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                    RequetsDispatcherObj.forward(req, res);
             }
             else 
             {
                   out.println("<h2> <font color='Red'>  Faildd...   </font> </h2>");
             }
             
         }
         catch(SQLException e)
         {
              out.println("<h1> "+e.getMessage()+" <h1>");
         }
     }
}
