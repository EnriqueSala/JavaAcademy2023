<!DOCTYPE html>
<html>

<head>
	<title>Actualizar usuario</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Banco Xideral</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar usuario</h3>
		
		<form action="UserControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="userId" value="${THE_USER.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_USER.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" 
								   value="${THE_USER.apellido}" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><input type="text" name="correo" 
								   value="${THE_USER.correo}" /></td>
					</tr>
					
					<tr>
						<td><label>Dirección:</label></td>
						<td><input type="text" name="direccion" 
								   value="${THE_USER.direccion}" /></td>
					</tr>
					
					<tr>
						<td><label>Teléfono:</label></td>
						<td><input type="text" name="telefono" 
								   value="${THE_USER.telefono}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="UserControllerServlet">Volver a la lista</a>
		</p>
	</div>
</body>

</html>











