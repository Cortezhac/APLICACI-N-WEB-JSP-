<%-- 
    Document   : index.jsp
    Created on : 15-jun-2020, 13:33:10
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "WEB-INF/Vistas-Parciales/css.jspf"%>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <h3>Bienvenido </h3>
        <a href="Index" class="btn btn-dark">Inicio</a>
        <a href="Categorias?opcion=listar" class="btn btn-dark">Categorias</a>
        <%@include file = "WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
