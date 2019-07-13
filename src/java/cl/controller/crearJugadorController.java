/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.entities.Jugador;
import cl.model.ServicioLocal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author 19933746-7
 */
@WebServlet(name = "crearJugadorController", urlPatterns = {"/crearJugadorController"})
@MultipartConfig
public class crearJugadorController extends HttpServlet {
    
    @EJB
    private ServicioLocal service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("jugadores", service.getJugadores());
        request.getRequestDispatcher("crudJugadores.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String posicion = request.getParameter("position");
        String msg = "";

        if (nombre.isEmpty()) {
            msg += "ingrese nombre";
        }
        if (posicion.isEmpty()) {
            msg += "Ingrese posición";
        }

        //Captura de Foto
        String foto = "foto";
        Part part1 = request.getPart("foto");
        int estado = 1;

        //Ubicamos la ruta en donde se almacenará la imagen
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + "img\\";

        //Declaracion de Stream para subir archivo
        OutputStream out = null;
        InputStream filecontent = null;

        //Configuracion del nombre del archivo
        String format = "";
        DateFormat hourdateFormat = new SimpleDateFormat("HHmmssddMMyyyy");
        String fecha = hourdateFormat.format(new Date());

        //Se Valida la extension
        if (part1.getSubmittedFileName().endsWith(".png")) {
            format = ".png";
        } else if (part1.getSubmittedFileName().endsWith(".jpg")) {
            format = ".jpg";
        } else if (part1.getSubmittedFileName().endsWith(".jpeg")) {
            format = ".jpeg";
        }
        if (format == "") {
            msg += "Error en el formato de imagen<br>";
        }

        if (msg.isEmpty()) {
            String file_photo = foto + "_" + fecha + format;
            try {
                out = new FileOutputStream(new File(savePath.replace("\\build", "")
                        + File.separator + file_photo));
                filecontent = part1.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

            } catch (FileNotFoundException fne) {
                fne.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }

            Jugador j = new Jugador();
            j.setEstado(1);
            j.setValor(100);
            j.setNombre(nombre);
            j.setPosicion(posicion);
            j.setPathphoto(file_photo);
            service.persist(j);
            doGet(request,response);
        } else {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("crudJugadores.jsp").forward(request, response);
        }

    }
}


