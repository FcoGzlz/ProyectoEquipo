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
 * @author 20317815-8
 */
@WebServlet(name = "EquipoController", urlPatterns = {"/EquipoController"})
public class EquipoController extends HttpServlet {
@EJB
private ServicioLocal service;
   
    

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("liga", service.getLigas());
        request.setAttribute("equipo",service.getEquipos() );
        request.getRequestDispatcher("vistaPrincipal.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String escudo = request.getParameter("escudo");
        String nombre = request.getParameter("nombre");
        String formacion = request.getParameter("formacion");
        String liga = request.getParameter("liga");
        String msg = "";
        if (escudo.isEmpty()) {
            msg +="Ingrese Escudo";
        }
        if (nombre.isEmpty()) {
            msg +="Ingrese Nombre";
        }
        if (formacion.equals("null")) {
            msg+="Seleccione Formación";
        }
        if (liga.equals("null")) {
            msg+="Seleccione liga";
        }
        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("crearEquipo.jsp").forward(request, response);
        } else {
            Usuario u = service.findUsuario(request.getParameter("rut"));
            Equipo e = new Equipo();
            e.setEscudo(escudo);
            e.setFormacion(formacion);
            e.setPresupuesto(10000);
            e.setUsuariofk(u);
            service.persist(e);
            
            
        }
    }

    
   
}
