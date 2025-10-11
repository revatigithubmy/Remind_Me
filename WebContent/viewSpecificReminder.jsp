<%@page import="com.revati.dbcon.ConnectDB" %>
<%@page import="java.sql.*" %>
<%@page import="com.revati.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Specific</title>
<link rel="stylesheet" href="css/viewSpecificReminder.css" />

</head>
<body>
		<h1>VIEW SPECIFIC REMINDER</h1>
		<form action="viewSpecificReminder.jsp"> 
				<input type="date"  name="rdate" placeholder="Enter Date">
				<br><br>
				<input type=submit>
		</form>
		<%
		try
		{
			String rdate = request.getParameter("rdate");
			if(rdate!=null)
			{
				%>
				<table>
					<tr>
						<th>Id</th>
						<th>title</th>
						<th>Description</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
				
				<% 
				Connection con = ConnectDB.getConnect();
				String uemail = User.getUemail();
				PreparedStatement ps = con.prepareStatement("select * from reminders where rdate=? and uemail=?");
				ps.setString(1, rdate);
				ps.setString(2,uemail);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
				%>
					<tr>
						<td><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(4)%></td>
						<td><a href="deleteReminder.jsp?rid=<%=rs.getInt(1)%>">Delete</a></td>
					</tr>
				<%
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		%>
	</table>
</body>
</html>