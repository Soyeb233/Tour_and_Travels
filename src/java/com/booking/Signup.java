/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booking;

/**
 *
 * @author soyeb
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Signup")
public class Signup extends HttpServlet
{
    Connection con;
    Statement st;
         public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
         {
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
               
                String username=req.getParameter("username");
                String password=req.getParameter("password");
                String mail=req.getParameter("mail");
                String mobile=req.getParameter("mobile");
                String gender=req.getParameter("gender");
    
                // i dont want to print output to the scrren;
                /*
                
                out.println("<h1> id :"+id+" </h1>");
                 out.println("<h1> username :"+username+" </h1>");
                  out.println("<h1> password :"+password+" </h1>");
                   out.println("<h1> mail  :"+mail+" </h1>");
                    out.println("<h1> gender :"+gender+" </h1>");
                     out.println("<h1> mobile :"+mobile+" </h1>");
*/
                try
                {
                    Conn c=new Conn();
                    String sql="insert into peopledetail(username,password,mail,mobile,gender)\n" +"values(? ,?,?,?,?);";
            
                   st=c.con.createStatement();
                   
                    PreparedStatement pst=c.con.prepareStatement(sql);
                   
                    pst.setString(1,username);
                    pst.setString(2, password);
                    pst.setString(3,mail);
                    pst.setString(4, mobile);
                    pst.setString(5,gender);
                    
                    pst.execute();
                    pst.close();
                    
                    
                    out.println("<h1>  <font color='greend'> Submiited Successfully </font></h2>");
                    
                    out.println("<a href ='index.html'>Login Page</a>");
                   
                    
                }
                catch(SQLException e)
                {
                    System.out.println("<h1>"+e.getMessage()+"occur here error </h1>" );
                }
             
         }
}
