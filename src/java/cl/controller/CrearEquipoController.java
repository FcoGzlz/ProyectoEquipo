/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.entities.Equipo;
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
 * @author Francisco
 */
@WebServlet(name = "CrearEquipoController", urlPatterns = {"/CrearEquipoController"})
public class CrearEquipoController extends HttpServlet {
    @EJB
    private ServicioLocal service;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("liga", service.getLigas());
        request.getRequestDispatcher("crearEquipo.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String nombre = request.getParameter("nombre");
      String escudo = request.getParameter("escudo");
      String formacion = request.getParameter("formacion");
      String liga = request.getParameter("liga");
      String msg = "";
      
        if (nombre.isEmpty()) {
            msg+="Ingrese nombre";
        }
        if (escudo.isEmpty()) {
            msg+="Ingrese escudo";
        }
        if (formacion.isEmpty()) {
            msg+="Ingrese formación";
        }
        if (liga.equals("null")) {
            msg+="Seleccione liga";
        }
        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("crearEquipi.jsp").forward(request, response);
        } else {
            Usuario u = service.findUsuario(request.getParameter("rut"));
            
            Equipo e = new Equipo();
            e.setPresupuesto(10000);
            e.setEscudo(escudo);
            e.setFormacion(formacion);
            e.setUsuariofk(u);
            e.setNombre(nombre);
            service.persist(e);
        }
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    
    protected void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    
    protected void leer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

}