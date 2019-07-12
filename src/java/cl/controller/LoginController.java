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

/**
 *
 * @author 20278034-2
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @EJB
    private ServicioLocal service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");
        if (request.getParameter("estado").equals("null")) {
            request.setAttribute("msg", "Por favor, ingrese un tipo de cuenta");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            int tipoCuenta = Integer.parseInt(request.getParameter("estado"));
            Usuario login = service.login(rut, clave, tipoCuenta);
            if (login != null) {
                if (tipoCuenta == 0) {
                    request.getSession().setAttribute("usuario", login);
                    request.getRequestDispatcher("crudUsuario.jsp").forward(request, response);
                    
                } else {
                    
                    request.getSession().setAttribute("administrador", login);
                    response.sendRedirect("crudAdministrador.jsp");
                }
            } else {
                request.setAttribute("msg", "Usuario no encontrado");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
