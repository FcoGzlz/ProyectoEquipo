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
        String nombre = request.getParameter("nombre");
        String msg = "";
        
        if(nombre.isEmpty()){
            msg += "Ingrese nombre de la liga";
             request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
        }
        else{
               msg +="Liga creada ";
                request.getRequestDispatcher("crudLigas.jsp").forward(request, response);
        }
        
       
        
    }
}
