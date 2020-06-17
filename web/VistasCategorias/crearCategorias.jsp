<%-- 
    Document   : crearCategorias
    Created on : 16-jun-2020, 2:01:08
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "../WEB-INF/Vistas-Parciales/css.jspf"%>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div class="container">
        <h1>Matenimiento categorias</h1>
        <form name="formcategoria" action="<%= request.getContextPath()%>/Categorias" method="POST">
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="txtNombreCat">Nombre Categoria: </label>
              <input type="text" name="txtNombreCat" class="form-control" id="txtNombreCat" value="<%= categoria.getNom_categoria()%>">
            </div>
            <div class="form-group col-md-3">
              <label for="txtEstadoCat">Estado Categoria: </label>
              <input type="text" class="form-control" name="txtEstadoCat" id="txtEstadoCat" value="<%= categoria.getEstado_categoria()%>">
            </div>
            <!-- Id para el form-->
            <input type="hidden" name="Id_categoria" value="<%= categoria.getId_categoria()%>">
          </div>
          <button type="submit" class="btn btn-primary">Crear</button>
          <input type="button" class="btn btn-secondary" onclick="regresar('<%=request.getContextPath()%>/Categorias?opcion=listar');" value="Regresar"> 
        </form>
        </div>
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
        <script type="text/javascript">
            function regresar(url){
                location.href = url;
            }
        </script>
    </body>
</html>
