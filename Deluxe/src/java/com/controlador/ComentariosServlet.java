/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Color;
import com.modelo.Comentarios;
import com.modelo.MetodosBlog;
import com.modelo.MetodosColor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldo
 */
@WebServlet(name = "ComentariosServlet", urlPatterns = {"/ComentariosServlet"})
public class ComentariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String accion = request.getParameter("accion");
        try{
         if(accion!=null){
             switch(accion){
                 case "Guardar":
                Guardar(request, response);
                 break;
             }
         }
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
             
         }
    }
    
      protected void Guardar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
        Comentarios obj = new Comentarios();
        MetodosBlog MC = new MetodosBlog();
        obj.setComentario(request.getParameter("TxtComentario"));
        obj.setEspecificacion(Integer.parseInt(request.getParameter("TxtEspecificacion")));
        obj.setId_usuario(Integer.parseInt(request.getParameter("TxtUsuario")));
        
        if(request.getParameter("TxtComentario")!=null){
            try {
                
                 MC.guardarcomentario(obj);
                 request.setAttribute("especificacion",obj.getEspecificacion());
                 RequestDispatcher rd = request.getRequestDispatcher("Comentarios.jsp");
                 rd.forward(request, response);
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
           
        }
       
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
