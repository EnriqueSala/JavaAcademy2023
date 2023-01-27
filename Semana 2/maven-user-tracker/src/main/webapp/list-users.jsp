<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Banco Xideral App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Banco Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add User -->
			
			<input type="button" value="Agregar usuario" 
				   onclick="window.location.href='add-user-form.jsp'; return false;"
				   class="add-user-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Direccion</th>
					<th>Telefono</th>
					<th>Opciones</th>
				</tr>
				
				<c:forEach var="tempUser" items="${USER_LIST}">
					
					<!-- set up a link for each user -->
					<c:url var="tempLink" value="UserControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>

					<!--  set up a link to delete a user -->
					<c:url var="deleteLink" value="UserControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempUser.nombre} </td>
						<td> ${tempUser.apellido} </td>
						<td> ${tempUser.correo} </td>
						<td> ${tempUser.direccion} </td>
						<td> ${tempUser.telefono} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Estás seguro que quieres eliminar este usuario?'))) return false">
							Eliminar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>