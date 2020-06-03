<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="background:#ffff33" >PRODUCTOS</h1>
	<p ><a href="Inicio?action=add" style="color:black;" >Nuevo Registro</a></p>
	<table border="3">
	    <tbody style="background: rgba(255, 128,0, 0.3); border: 1px solid rgba(100, 200, 0, 0.3);">
		<tr>
		    <th>ID</th>
		    <th>DESCRIPCION</th>
		    <th>STOCK</th>
		    <th></th>
		    <th></th>
		</tr>
	   	 </tbody>	
		<c:forEach var="item" items="${productos}">
		    <tbody style="background: rgba(173, 216, 230, 0.3); border: 1px solid rgba(100, 200, 0, 0.3);">
		     <tr>  
			<td style="color:blue;">${item.id}</td>
			<td>${item.descripcion}</td>
			<td>${item.stock}</td>
			<td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
			<td><a href="Inicio?action=delete&id=${item.id}"
			        onclick="return(confirm('ESTA SEGURO DE ELIMIAR?'))"
				style="color:red;">Eliminar</a></td>
		    </tr>
		     </tbody>
		</c:forEach>
	
	</table>

    </body>
</html>
