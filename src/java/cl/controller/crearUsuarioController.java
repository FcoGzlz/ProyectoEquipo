/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.entities.Usuario;
import cl.model.ServicioLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "crearUsuarioController", urlPatterns = {"/crearUsuarioController"})
public class crearUsuarioController extends HttpServlet {

    @EJB
    private ServicioLocal service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("usuarios", service.getUsuarios());
        request.getRequestDispatcher("createUserTest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boton = request.getParameter("boton");
        switch (boton) {
            case "crear":
                crear(request, response);
                break;
            
            case "actualizar":
                actualizar(request, response);
                break;
            
            case "cancelar":
                doGet(request, response);
                break;
            default:
                otros(request, response);
        }
      
    }
    
   
    
    protected void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String tipoCuenta = request.getParameter("tipoCuenta");
        String msg = "";

        if (rut.isEmpty()) {
            msg += "Debe ingresar RUT<br>";
        }

        if (nombre.isEmpty()) {
            msg += "Debe ingresar un nombre<br>";

        }

        if (apellido.isEmpty()) {
            msg += "Debe ingresar un apellido<br>";

        }

        if (tipoCuenta.equals("null")) {
            msg += "Debe ingresar un tipo de cuenta<br>";

        }

        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("createUserTest.jsp").forward(request, response);
        } else {
            Usuario usuarioExistente = service.findUsuario(rut);
            if (usuarioExistente != null) {
                msg += "el RUT ingresado ya existe<br>";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("createUserTest.jsp").forward(request, response);
            } else {
                int tipoCuentaInt = Integer.parseInt(tipoCuenta);
                Usuario u = new Usuario();
                u.setRut(rut);
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setClave(Hash.md5(Hash.sha1("123")));
                u.setEsadministrador(tipoCuentaInt);
                service.persist(u);
                
                doGet(request, response);
            }

        }
    
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String tipoCuenta = request.getParameter("tipoCuenta");
        String msg = "";

        if (rut.isEmpty()) {
            msg += "Debe ingresar RUT<br>";
        }

        if (nombre.isEmpty()) {
            msg += "Debe ingresar un nombre<br>";

        }

        if (apellido.isEmpty()) {
            msg += "Debe ingresar un apellido<br>";

        }

        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("createUserTest.jsp").forward(request, response);
        } else {
            
            Usuario usuarioExistente = service.findUsuarioId(Integer.parseInt(request.getParameter("id")));
                int tipoCuentaInt = Integer.parseInt(tipoCuenta);
                EEEEEEEEEEEEEEEHHHHHHHHHHHHHHHH: System.out.println(tipoCuentaInt);
                usuarioExistente.setRut(rut);
                usuarioExistente.setNombre(nombre);
                usuarioExistente.setApellido(apellido);
                //usuarioExistente.setClave(Hash.md5(Hash.sha1("123")));
                usuarioExistente.setEsadministrador(tipoCuentaInt);
                service.merge(usuarioExistente);
                doGet(request, response);
            

        }
    
    }
      
    protected void otros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boton = request.getParameter("boton");
        String peticiones[] = boton.split("_");
        String peticion = peticiones[1];
        String rut = peticiones[0];
        
        switch (peticion) {
            case "leer":
                leer(request, response, rut);
                break;
            case "eliminar":
                eliminar(request, response, rut);
        }
    
    }
    protected void leer(HttpServletRequest request, HttpServletResponse response, String rut)
            throws ServletException, IOException {
        Usuario u = service.findUsuario(rut);
        String tipoCuenta ="";
        String tipoCuentaActual ="";
        String tipoCuentaBool ="";
        request.setAttribute("usuario", u);
        if (u.getEsadministrador()==1) {
            tipoCuenta = "Estándar";
            tipoCuentaActual = "Administrador";
            tipoCuentaBool = "0";
        } else {
            tipoCuenta = "Administrador";
            tipoCuentaActual = "Estándar";
            tipoCuentaBool = "1";
        }
        request.setAttribute("tipoCuenta", tipoCuenta);
        request.setAttribute("tipoCuentaBool", tipoCuentaBool);
        request.setAttribute("tipoCuentaActual", tipoCuentaActual);
        request.getRequestDispatcher("verUsuario.jsp").forward(request, response);
    
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response, String rut)
            throws ServletException, IOException {
        Usuario u = service.findUsuario(rut);
        service.remove(u);
        doGet(request, response);
    }
    
    

}
