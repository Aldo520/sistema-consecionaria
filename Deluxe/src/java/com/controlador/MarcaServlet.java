/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Marca;
import com.modelo.MetodosMarca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldo
 */
public class MarcaServlet extends HttpServlet {

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
        if (accion != null) {
            switch (accion) {
                case "Guardar":
                    Guardar(request, response);
                    break;
                case "Modificar":
                    Modificar(request, response);
                    break;
                case "Eliminar":
                    Eliminar(request, response);
                    break;
            }
        }
    }catch(Exception e){
        
    }
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response) {

        Marca obj = new Marca();
        MetodosMarca ob = new MetodosMarca();
        obj.setMarca(request.getParameter("TxtMarca").toUpperCase());

        if (request.getParameter("TxtMarca") != null) {
            try {
                ob.GuardarMarca(obj);
             
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }
    
    
   
        protected void Modificar(HttpServletRequest request, HttpServletResponse response) {

        Marca obj = new Marca();
        MetodosMarca ob = new MetodosMarca();
        obj.setRegistro(Integer.parseInt(request.getParameter("TxtRegistro")));
        obj.setMarca(request.getParameter("TxtMarca").toUpperCase());

        if (request.getParameter("TxtMarca") != null) {
            try {
                ob.ModificarMarca(obj);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }
    
    
    
    
        protected void Eliminar(HttpServletRequest request, HttpServletResponse response) {

        Marca obj = new Marca();
        MetodosMarca ob = new MetodosMarca();
        obj.setRegistro(Integer.parseInt(request.getParameter("TxtRegistro")));
        obj.setMarca(request.getParameter("TxtMarca").toUpperCase());

        if (request.getParameter("TxtMarca") != null) {
            try {
                ob.EliminarMarca(obj);
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
