<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmproducto
    Created on : 02-jun-2020, 0:54:01
    Author     : GUIDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
	<link href="hoja.css" rel="stylesheet">
    </head>
    <body>
          <h1> 
	    <c:if test="${producto.id==0}"  >Nuevo</c:if>
	    <c:if test="${producto.id!=0}" >Editar</c:if>
	</h1>
	
	<form action="Inicio" method="post" style="background:#ccffcc">

	<input type="hidden" name="id" value="${producto.id}"/>
    <ul>
	 <li>
		<label for="mail">Descripcion:</label>
		<textarea type="text" name="descripcion" value="${producto.descripcion}"></textarea>
	</li>
	 <li>
	<label>Stock</label>
	<input type="number" name="stock" value="${producto.stock}"/>
	 </li>
    </ul>
	<br>
	<input type="submit" value="Enviar"/>
	
    </form>

    </body>
</html>
