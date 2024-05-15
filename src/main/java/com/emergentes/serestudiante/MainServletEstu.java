/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.serestudiante;

import com.emergentes.DAOS.estudianteDAO;
import com.emergentes.DAOS.estudianteDAOimpl;
import com.emergentes.estudiante.conDB;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALVARO
 */
@WebServlet(name = "MainServletEstu", urlPatterns = {"/MainServletEstu"})
public class MainServletEstu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = conDB.getConnection();
            estudianteDAOimpl dao = new estudianteDAOimpl();
            ArrayList<Estudiante> estu = (ArrayList<Estudiante>) dao.getAll();
            request.setAttribute("estu", estu);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al conectar con la base de datos");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
        String action = request.getParameter("action");
        estudianteDAOimpl dao = new estudianteDAOimpl();
        
        if (action != null) {
            switch (action) {
        
                    case "insertar":
                    agregarEstudiante(request, dao);
                    break;
                case "ver":
                    // Lógica para ver
                    verEstudiante(request, response, dao);
                    break;
                case "actualizar":
                    actualizarEstudiante(request, dao);
                    break;
                case "eliminar":
                    eliminarEstudiante(request, dao);
                    break;
                case "select":
                    seleccionarEstudiante(request, response, dao);
                    break;
                default:
                    break;
            }
        
        
    }
        response.sendRedirect("MainServletEstu");
        } catch (Exception ex) {
            Logger.getLogger(MainServletEstu.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    
     private void agregarEstudiante(HttpServletRequest request, estudianteDAOimpl dao)
            throws ServletException, IOException {
        // Implementación para agregar un estudiante
        try {
            // Obtener los datos del formulario
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String seminario = request.getParameter("seminario");
            boolean confirmacion = Boolean.parseBoolean(request.getParameter("confirmacion"));
            Date createDate = Date.valueOf(request.getParameter("fecha"));
            // Crear un objeto Estudiante con los datos recibidos
            Estudiante estu = new Estudiante();
            estu.setNombre(nombre);
            estu.setApellido(apellido);
            estu.setSeminario(seminario);
            estu.setConfirmacion(confirmacion);
            estu.setFecha(createDate);
            // Insertar el estudiante en la base de datos
            dao.insertar(estu);
            // Redireccionar a la página principal
            //response.sendRedirect("MainServletEstu");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error al agregar el estudiante");
        }
    }

    
     private void verEstudiante(HttpServletRequest request, HttpServletResponse response, estudianteDAOimpl dao)
            throws ServletException, IOException {
        // Lógica para ver un estudiante
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Estudiante estudiante = dao.getById(id);
            request.setAttribute("estudiantes", estudiante);
            request.getRequestDispatcher("CRUD/editar.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error al ver el estudiante");
        }
    }
private void actualizarEstudiante(HttpServletRequest request, estudianteDAOimpl dao)
            throws ServletException, IOException {
        // Lógica para actualizar un estudiante
        try {
            // Obtener los datos del formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String seminario = request.getParameter("seminario");
            boolean confirmacion = Boolean.parseBoolean(request.getParameter("confirmacion"));
            Date fecha = Date.valueOf(request.getParameter("fecha"));
            // Crear un objeto Estudiante con los datos recibidos
            Estudiante estudiante = new Estudiante();
            estudiante.setId(id);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setSeminario(seminario);
            estudiante.setConfirmacion(confirmacion);
            estudiante.setFecha(fecha);
            
            // Actualizar el estudiante en la base de datos
            dao.actualizar(estudiante);
            
            // Redireccionar a la página principal
            //response.sendRedirect("MainServletEstu");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error al actualizar el estudiante");
        }
    }

    private void eliminarEstudiante(HttpServletRequest request, estudianteDAOimpl dao)
            throws ServletException, IOException {
        // Lógica para eliminar un estudiante
        try {
            // Obtener el ID del estudiante a eliminar
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Eliminar el estudiante de la base de datos
            dao.eliminar(id);
            
            // Redireccionar a la página principal
            //response.sendRedirect("MainServletEstu");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error al eliminar el estudiante");
        }
    }

    private void seleccionarEstudiante(HttpServletRequest request, HttpServletResponse response, estudianteDAOimpl dao)
            throws ServletException, IOException {
        // Lógica para seleccionar un estudiante
        try {
            // Obtener el ID del estudiante a seleccionar
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Obtener el estudiante de la base de datos
            Estudiante estu = dao.getById(id);
            
            // Establecer el estudiante como atributo de la solicitud
            request.setAttribute("estudiante", estu);
            
            // Redireccionar a la página de edición
            request.getRequestDispatcher("CRUD/eliminar.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error al seleccionar el estudiante");
        }

}
    
}