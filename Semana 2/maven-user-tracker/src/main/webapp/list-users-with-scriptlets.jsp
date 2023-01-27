<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Banco Xideral App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the users from the request object (sent by servlet)
	List<User> theUsers = 
			(List<User>) request.getAttribute("USER_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Banco Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Dirección</th>
				</tr>
				
				<%
								for (User tempUser : theUsers) {
								%>
				
					<tr>
						<td> <%=tempUser.getNombre()%> </td>
						<td> <%= tempUser.getApellido() %> </td>
						<td> <%= tempUser.getCorreo() %> </td>
						<td> <%= tempUser.getDireccion() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








