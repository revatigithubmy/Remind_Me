package com.revati.service;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revati.dbcon.ConnectDB;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try
		{	
			int uid=0;
			String uname = request.getParameter("uname");
			String ucontact = request.getParameter("ucontact");
			String uemail = request.getParameter("uemail"); 
			String upassword = request.getParameter("upassword");
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("select * from users where uemail=?");
			ps1.setString(1, uemail);
			ResultSet res = ps1.executeQuery();
			if(res.next())
			{
				System.out.println("User Already Exit");
				response.sendRedirect("error.html");
			}
			else
			{
				PreparedStatement ps3 = con.prepareStatement("insert into users values(?,?,?,?,?)");
				ps3.setInt(1, uid);
				ps3.setString(2, uname);
				ps3.setString(3, ucontact);
				ps3.setString(4,uemail);
				ps3.setString(5,upassword);
				
				int i =ps3.executeUpdate();
				 if (i > 0)
				 {
			            response.sendRedirect("index.html");
			     } else 
			     {
			            response.sendRedirect("error.html");
			     }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");

		}
		
	}

}
