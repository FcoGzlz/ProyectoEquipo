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
        request.getRequestDispatcher("createUserTest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            }

        }
    }

}
