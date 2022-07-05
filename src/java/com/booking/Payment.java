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
@WebServlet("/Payment")
public class Payment extends HttpServlet
{
       Connection con;
    Statement st;
        public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
       {
               res.setContentType("text/html");
            PrintWriter out=res.getWriter();
                
                String owner =req.getParameter("owner");
                String cvv=req.getParameter("cvv");
                String card_number=req.getParameter("card_number");
                String price=req.getParameter("price");
                String months=req.getParameter("months");
                String years=req.getParameter("years");
                
                
                    
              
               //String sql="select * from  bookingdetail where name=?, mail=?, adults=?,children=?,check_in_date=?,check_out_date=?,room_preference=?,message=?" ;
               
                //String sql="insert into peopleinfo(id,username,password,mail,gender,mobile)\n" +"values(?,?,?,?,?,?);";
                try 
                {
                  Conn c=new Conn();
                  //String sql="insert into bookingdetail (name,mail,mobile,adults, children,check_in_date,check_out_date,room_preference,message           )\n  " + "values (?, ? , ? , ? , ? , ? , ? , ?, ?  );";
                     String sql="insert into payment(owner,cvv,card_number,price,months,years\n)"+"values(?,?,?,?,?,?);";
                  PreparedStatement pst =c.con.prepareStatement(sql);
                       pst.setString(1, owner);
                       pst.setString(2,cvv);
                       pst.setString(3,card_number);
                       pst.setString(4, price);
                       pst.setString(5,months);
                       pst.setString(6,years);
                       
                       
                       
                       
                       
                       
                       pst.execute();
                       
                       int rowColumn=pst.executeUpdate();
                       if(rowColumn==1)
                       {
                            
       
                             
                                out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Succesfully....');");
       out.println("</script>");
        
                             RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                  //RequetsDispatcherObj.forward(req, res);
                   RequetsDispatcherObj.include(req,res);
       
       
       
       
       
                       }
                       else
                       {
                             out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
                       }
                   }
         //   res.sendRedirect("Log.html"); 
               
                                
                
                catch(SQLException e)
                {
                    
                    out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
       out.println("<h1>"+e.getMessage()+"<h1>");
       /*
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
                 //  RequetsDispatcherObj.forward(req, res);
                  RequetsDispatcherObj.include(req,res);
*/
                 System.out.println(e.getMessage()+ "From here");
                }
                catch(NullPointerException e)
                {
                      out.println("<script type=\"text/javascript\">");
       out.println("alert('Submitted Failed....');");
       out.println("</script>");
        RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/index_1.html");
               //   RequetsDispatcherObj.forward(req, res);
                RequetsDispatcherObj.include(req,res);
                }
                    
                        
       }   
}
