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
                                <th>Opciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${requestScope.equipos}" var= "e">
                                <tr>
                                  <td>${e.escudo}</td>  
                                  <td>${e.nombre}</td>  
                                  <td>${e.formacion}</td>  
                                  <td>${e.presupuesto}</td>  
                                  <td>${e.usuario}</td>  
                                  <td>${e.ligaFK}</td> 
                                  <td>
                                      <button value="leer" name="boton">Actualizar Equipo</button>
                                      <button value="eliminar" name="boton">Eliminar</button>
                                  </td>
                                </tr>
                                </c:forEach>
                        </tbody>
                    </table>
    </body>
</html>
