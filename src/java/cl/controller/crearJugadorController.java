/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

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
 * @author 19933746-7
 */
@WebServlet(name = "crearJugadorController", urlPatterns = {"/crearJugadorController"})
public class crearJugadorController extends HttpServlet {
    @EJB
    private ServicioLocal service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("crudJugadores.jsp").forward(request, response);
        request.setAttribute("equipos", service.getEquipos());
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String posicion = request.getParameter("position");
        String equipo = request.getParameter("equipo");
        String msg ="";
        
        if (nombre.isEmpty()) {
            msg += "ingrese nombre";
        }
        if (posicion.isEmpty()) {
            msg += "Ingrese posición";
        }
        if (equipo.equals("null")) {
            msg += "Debe seleccionar un equipo";
        }
        
        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("crudJugadores.jsp").forward(request, response);
        } else {
        }
    }

    

}
