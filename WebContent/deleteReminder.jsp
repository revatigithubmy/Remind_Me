<%@page import="com.revati.dbcon.ConnectDB" %>
<%@page import="java.sql.*" %>
<%@page import="com.revati.pojo.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/deleteReminder.css" />

</head>
<body>
		<%
		try
		{
			String rid = request.getParameter("rid");
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("delete from reminders where rid=?");
			ps.setInt(1, Integer.parseInt(rid));
			int i= ps.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("viewAllReminder.jsp");
			}
			else
			{
				response.sendRedirect("error.html");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		%>
</body>
</html>