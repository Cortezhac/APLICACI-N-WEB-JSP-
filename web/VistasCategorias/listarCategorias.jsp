<%-- 
    Document   : listarCategorias
    Created on : 15-jun-2020, 14:36:04
    Author     : Admin
--%>

<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "../WEB-INF/Vistas-Parciales/css.jspf"%>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div class="row contenido justify-content-center">
            <div class="col-sm-10 p-2">
                <a href="#" class="btn btn-success"><i class="fa fa-edit"></i></a>
                <h3>Listado de categorias</h3>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                NOMBRE
                            </th>
                            <th>
                                ESTADO
                            </th>
                            <th>
                                ACCIONES
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            for(int i = 0; i < lista.size(); i++){
                                Categoria categoria = new Categoria();
                                categoria = (Categoria)lista.get(i); // Casting
                        
                        %>
                        <tr>
                            <td><%=categoria.getNom_categoria()%></td>
                            <td><%=categoria.getEstado_categoria() %></td>
                            <td>
                                <a href="#" role="button" class="btn btn-info"><i class="fa fa-edit"></i></a>
                                <a href="#" role="button" class="btn btn-danger"><i class="fas fa-trash-alt"></i></i></a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

