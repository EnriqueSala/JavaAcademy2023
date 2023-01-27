<!DOCTYPE html>
<html>

<head>
	<title>Agregar usuario</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">	
	<meta charset="UTF-8">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Banco Xideral</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Agregar usuario</h3>
		
		<form action="UserControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><input type="text" name="correo" /></td>
					</tr>
					
					<tr>
						<td><label>Dirección:</label></td>
						<td><input type="text" name="direccion" /></td>
					</tr>
					
					<tr>
						<td><label>Telefono:</label></td>
						<td><input type="text" name="telefono" /></td>
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











