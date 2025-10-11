package com.revati.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revati.dbcon.ConnectDB;
import com.revati.pojo.User;

/**
 * Servlet implementation class AddNewReminder
 */
public class AddNewReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewReminder() {
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
			int rid =0;
			String rtitle = request.getParameter("rtitle");
			String rdesc = request.getParameter("rdesc");
			String rdate = request.getParameter("rdate");
			String uemail = User.getUemail();
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into reminders values(?,?,?,?,?)");
			ps1.setInt(1, rid);
			ps1.setString(2, rtitle);
			ps1.setString(3, rdesc);
			ps1.setString(4, rdate);
			ps1.setString(5, uemail);
			
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Reminder added....");
				response.sendRedirect("dashboard.html");
			}else
			{
				response.sendRedirect("error.html");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
