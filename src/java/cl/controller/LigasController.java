/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.entities.Liga;
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
@WebServlet(name = "LigasController", urlPatterns = {"/LigasController"})
public class LigasController extends HttpServlet {
@EJB
private ServicioLocal service;
   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      request.setAttribute("liga",service.getLigas());
      request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
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
                        
            default:
                otros(request, response);
        }
            
    }
    
    protected void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
        String msg = "";
        
        if(nombre.isEmpty()){
            msg += "Ingrese nombre de la liga";
             request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
        }
        else{
            Liga l = new Liga();
            l.setNombre(nombre);
            service.persist(l);
               msg +="Liga creada ";
                request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
        }
        
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String msg = "";
        
        if(nombre.isEmpty()){
            msg += "Ingrese nombre de la liga";
             request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
        }
        else{
            Liga l = service.findLiga(id);
            l.setNombre(nombre);
            service.merge(l);
            doGet(request, response);
        }
    
    }
    protected void otros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String boton = request.getParameter("boton");
        String cadenaSeparada[] = boton.split("-");
        String peticion = cadenaSeparada[0];
        int id = Integer.parseInt(cadenaSeparada[1]);
        switch (peticion) {
            case "eliminar":
                eliminar(request, response, id);
                break;
            case "leer":
                leer(request, response, id);
                break;
    
    }
    }
    protected void leer(HttpServletRequest request, HttpServletResponse response,int id)
            throws ServletException, IOException {
        request.getRequestDispatcher("verLiga.jsp").forward(request, response);
    
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException {
           Liga liga = service.findLiga(id) ;
           service.remove(liga);
           doGet(request, response);
    }
}
