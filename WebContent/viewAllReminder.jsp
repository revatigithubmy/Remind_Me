<%@page import="com.revati.dbcon.ConnectDB" %>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All</title>
<link rel="stylesheet" href="css/viewAllReminder.css" />

</head>
<body>
		<table>
			<tr>
			<th>Rid</th>
			<th>title</th>
			<th>Description</th>
			<th>Date</th>
			<th>Action</th>
			</tr>
			
			<%
			try
			{
				
				
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps = con.prepareStatement("select * from reminders");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
			%>
					<tr>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><a href="deleteReminder.jsp?rid=<%=rs.getInt(1)%>">Delete</a></td>
					</tr>
			
			<%
				}//while-end
			}//try-end	
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
			%>
		</table>
</body>
</html>