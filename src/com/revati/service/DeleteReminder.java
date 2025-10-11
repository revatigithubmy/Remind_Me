package com.revati.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revati.dbcon.ConnectDB;

/**
 * Servlet implementation class DeleteReminder
 */
public class DeleteReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReminder() {
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
			String rtitle = request.getParameter("rtitle");
			String rdate = request.getParameter("rdate");
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("select * from reminders where rtitle=? and rdate=?");
			ps1.setString(1, rtitle);
			ps1.setString(2, rdate);
			ResultSet res = ps1.executeQuery();
			if(res.next())
			{
				PreparedStatement ps2 = con.prepareStatement("delete * from reminders where rtitle=?");
				ps2.setString(1, rtitle);
				int rs2 = ps2.executeUpdate();
				
				if(rs2>0)
				{
					System.out.println("Reminder Delete Successfully...!!");
					response.sendRedirect("dashboard.html");
				}else
				{
					System.out.println("Failed to Delete reminder");
					response.sendRedirect("error.html");
				}	
			}
			else
			{
				System.out.println("Reminder Not Exit..!!");
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
