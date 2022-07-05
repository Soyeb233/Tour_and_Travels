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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soyeb
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet
{
       Connection con;
    Statement st;
        public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
       {
               res.setContentType("text/html");
            PrintWriter out=res.getWriter();
                
                 String name=req.getParameter("name");
                  String phone=req.getParameter("phone");
                          String mail=req.getParameter("mail");
                String place=req.getParameter("place");
              
                String guests=req.getParameter("guests");
                
                
                
                String arrival_date=req.getParameter("arrival_date");
                String leaving_date=req.getParameter("leaving_date");
                
               
                
                
               //String sql="select * from  bookingdetail where name=?, mail=?, adults=?,children=?,check_in_date=?,check_out_date=?,room_preference=?,message=?" ;
               
                //String sql="insert into peopleinfo(id,username,password,mail,gender,mobile)\n" +"values(?,?,?,?,?,?);";
                try 
                {
                  Conn c=new Conn();
                  //String sql="insert into bookingdetail (name,mail,mobile,adults, children,check_in_date,check_out_date,room_preference,message           )\n  " + "values (?, ? , ? , ? , ? , ? , ? , ?, ?  );";
                     String sql="insert into booking(name,phone,mail ,place,guests,arrival_date,leaving_date \n)"+"values(?,?,?,?,?,?,?);";
                  PreparedStatement pst =c.con.prepareStatement(sql);
                       pst.setString(1, name);
                       pst.setString(2,phone);
                       pst.setString(3,mail);
                       pst.setString(4, place);
                       pst.setString(5,guests);
                       pst.setString(6,arrival_date);
                       
                       pst.setString(7,leaving_date);
                       
                       
                       
                       
                       pst.execute();
                       
                       int rowColumn=pst.executeUpdate();
                       if(rowColumn==1)
                       {
                           /*
                             out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Succesfully....');");
       out.println("</script>");
                           */
                           RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_2.html");
               //   RequetsDispatcherObj.forward(req, res);
                RequetsDispatcherObj.include(req,res);
                          
                       }
                       else
                       {
                             out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
               //   RequetsDispatcherObj.forward(req, res);
                RequetsDispatcherObj.include(req,res);
                       }
                   }
         //   res.sendRedirect("Log.html"); 
               
                                
                
                catch(SQLException e)
                {
                    /*
                    out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
*/
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_2.html");
                   RequetsDispatcherObj.forward(req, res);
                 // RequetsDispatcherObj.include(req,res);
                }
                catch(NullPointerException e)
                {
                      out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_2.html");
               //   RequetsDispatcherObj.forward(req, res);
                RequetsDispatcherObj.include(req,res);
                }
                    
                        
       }   
}
