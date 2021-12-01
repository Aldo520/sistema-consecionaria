/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.google.gson.Gson;
import com.modelo.MetodosUsuario;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Alvarado
 */
@MultipartConfig
public class UsuarioServlet extends HttpServlet {

    Usuario user = new Usuario();
    MetodosUsuario mUser = new MetodosUsuario();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            int respuesta = 0;
            if (accion != null) {
                switch (accion) {
                    case "GuardarUsuario":
                        respuesta = GuardarUsuario(request, response);
                        break;
                    case "Modificar":
                        respuesta = ModificarUsuario(request, response);
                        break;
                    case "Eliminar":
                        respuesta = EliminarUsuario(request, response);
                        break;
                }
                String retorno = this.gson.toJson(respuesta);
                response.setContentType("application/json");
                out.print(retorno);

            }
        } catch (Exception ex) {
            
        }
    }

    protected int GuardarUsuario(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        user.setNombre_usuario(request.getParameter("txtUserName").toUpperCase());
        user.setCorreo(request.getParameter("txtCorreo").toUpperCase());
        user.setContrasenia(request.getParameter("txtContrasenia").toUpperCase());
        user.setTipo_usuario(request.getParameter("tipousuario").toUpperCase());
        int respuesta = 0;
        try {
            Part part = request.getPart("Imagen");
            InputStream inputStream = part.getInputStream();
            user.setFoto(inputStream);

            respuesta = mUser.GuardarUsuario(user);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return respuesta;
    }

    protected int ModificarUsuario(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        user.setNombre_usuario(request.getParameter("txtUserName").toUpperCase());
        user.setCorreo(request.getParameter("txtCorreo").toUpperCase());
        user.setTipo_usuario(request.getParameter("tipousuario").toUpperCase());
        user.setId(Integer.parseInt(request.getParameter("txtID")));
        int respuesta = 0;
        try {
            Part part = request.getPart("Imagen");
            InputStream inputStream = part.getInputStream();
            if (inputStream.available() != 0) {
                user.setFoto(inputStream);
                respuesta = mUser.ModificarUsuario(user);
            } else {
                respuesta = mUser.Modificar(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return respuesta;

    }

    protected int EliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        int respuesta = 0;

        user.setId(Integer.parseInt(request.getParameter("txtID")));
        try {
            respuesta = mUser.EliminarUsuario(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return respuesta;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
