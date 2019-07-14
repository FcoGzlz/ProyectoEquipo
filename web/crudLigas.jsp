<%-- 
    Document   : crudLigas
    Created on : 04-07-2019, 21:55:14
    Author     : 20278034-2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="LigasController" method="POST">
            
            Nombre: <input type="text" name="nombre">
         
            <button type="submit">Crear</button>
        </form>
        ${requestScope.msg}
        
         <table>
                        <thead>
                            <tr>                                                             
                                <th>Nombre</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${requestScope.liga}" var= "l">
                                <tr>
                                  <td>${l.nombre}</td>
                                  <td>
                                      <button value="leer" name="boton">Ver</button>
                                      <button value="eliminar" name="boton">Eliminar</button>
                                  </td>
                                </tr>
                                </c:forEach>
                        </tbody>
                    </table>
    </body>
</html>
