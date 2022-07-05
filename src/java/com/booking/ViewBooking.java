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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/ViewBooking")
public class ViewBooking  extends HttpServlet
{
    
         Connection con;
         Statement st;
          public void doGet(ServletRequest req,ServletResponse res)throws ServletException,IOException, SQLException
          {
                      res.setContentType("text/html") ;
                      PrintWriter out=res.getWriter();
                      out.println("<h1> Menu Booking System </h1>");
                      try
                      {   
                        String sql="select * from bookingdetail ";
                        
                        Conn c=new Conn();
                        PreparedStatement pst=c.con.prepareStatement(sql) ;
                        ResultSet result=pst.executeQuery();
                        
                        while(result.next())
                        {
                               String name=result.getString("name");
                               String mail=result.getString("mail");
                               String mobile=result.getString("mobile");
                               String adults=result.getString("adults");
                               String children=result.getString("children");
                               String check_in_date=result.getString("check_in_date");
                               String check_out_date=result.getString("check_out_date");
                               String room_preference=result.getString("room_preference") ;
                               String message=result.getString("message");
                               
                               System.out.println("Name :"+name +"  Mail :"+mail +" Mobile"+mobile +" Adults "+adults +" Children :"+children +" Check in Date   "+check_in_date +" "
                                       + "Check out Date  "+check_out_date+"  Room Preference  "+room_preference +"  Message :"+message );
                                       
                                       
                               
                        }
                      }
                      catch(SQLException e)
                      {
                          
                          out.println("<h1> "+e.getMessage()+" <h1>");
                          
                      }
          }
}
