/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contact")
public class Contact  extends HttpServlet
{
    Connection con;
    Statement st;
   public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
    {
          res.setContentType("text/html");
          PrintWriter out=res.getWriter();
          
          
                String username=req.getParameter("username");
                String mail=req.getParameter("mail");
                String mobile=req.getParameter("mobile");
                String subject=req.getParameter("subject");
                String message=req.getParameter("message");
          
          try 
          {
              Conn c=new Conn();
              String sql="insert into contact( username,mail,mobile,subject,message  ) \n"+"values( ?,?,?,?,?   );";
               st=c.con.createStatement();
              PreparedStatement pst=c.con.prepareStatement(sql);
              
              pst.setString(1,username);
              pst.setString(2,mail);
              pst.setString(3,mobile);
              pst.setString(4,subject);
              pst.setString(5,message);
              pst.execute();
              
              int rowAffect=pst.executeUpdate();
              System.out.println(rowAffect);
           //   pst.close();
              if(rowAffect==1)
              {
                 out.println("<script type=\"text/javascript\">");
                 out.println("alert('Message sent  Succesfully....');");
                 out.println("</script>");
                    RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                    RequetsDispatcherObj.forward(req, res);
                // RequetsDispatcherObj.include(req,res);
              }
              else
              {
                  /*
                   out.println("<script type=\"text/javascript\">");
       out.println("alert('Message sent  Faild....');");
       out.println("</script>");
                   */
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                 RequetsDispatcherObj.forward(req, res);
               //  RequetsDispatcherObj.include(req,res);
                //  out.println( " <h1> Message not sent Successfully  </h1>");
              }
                      
          }
          catch(SQLException e)
          { 
              /*
              out.println("<script type=\"text/javascript\">");
       out.println("alert('Message sent  Faild....');");
       out.println("</script>");
*/
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                    RequetsDispatcherObj.forward(req, res);
              //   RequetsDispatcherObj.include(req,res);
                 
                 out.println(e.getMessage()+"  From heare error rises");
          }
    }
}
