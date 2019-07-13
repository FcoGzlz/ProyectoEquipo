<%-- 
    Document   : vsitaPrincipal
    Created on : 04-07-2019, 21:59:20
    Author     : 20278034-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>       
        <a href="CrearEquipoController">crear Equipo</a>
        <table>
                        <thead>
                            <tr>                                                             
                                <th>Escudo</th>                                                                                                                         
                                <th>Nombre</th>                                                                                                                         
                                <th>formacion</th>                                                                                                                         
                                <th>Presupuesto</th>                                                                                                                         
                                <th>Jugador</th>                                                                                                                         
                                <th>Liga</th>                                                                                                                         
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${requestScope.equipos}" var= "e">
                                <tr>
                                  <td>${e.nombre}</td>  
                                  <td>${e.nombre}</td>  
                                  <td>${e.nombre}</td>  
                                  <td>${e.nombre}</td>  
                                  <td>${e.nombre}</td>  
                                  <td>${e.nombre}</td>  
                                </tr>
                                </c:forEach>
                        </tbody>
                    </table>
    </body>
</html>
