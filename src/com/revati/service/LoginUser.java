package com.revati.service;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revati.dbcon.ConnectDB;
import com.revati.pojo.User;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
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
			String uemail = request.getParameter("uemail"); 
			String upassword = request.getParameter("upassword");
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("select * from users where uemail=? and upassword=?");
			ps1.setString(1, uemail);
			ps1.setString(2, upassword);
			ResultSet res = ps1.executeQuery();
			
			if(res.next())
			{
				User.setUid(res.getInt(1));
				User.setUname(res.getString(2));
				User.setUcontact(res.getString(3));
				User.setUemail(res.getString(4));
				
				
				System.out.println("Login Succesfully...!!!");
				response.sendRedirect("dashboard.html");
			}else
			{
				
				response.sendRedirect("error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");
			
		}
	}

}
