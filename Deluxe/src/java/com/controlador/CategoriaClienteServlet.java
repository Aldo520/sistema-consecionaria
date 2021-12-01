/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.CategoriaCliente;
import com.modelo.MetodosCategoriaCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Alvarado
 */
public class CategoriaClienteServlet extends HttpServlet {

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
        try {
            if (accion != null) {
                switch (accion) {
                    case "GuardarCategoriaCliente":
                        GuardarCategoriaCliente(request, response);
                        break;
                    case "ModificarCategoriaCliente":
                        ModificarCategoriaCliente(request, response);
                        break;
                    case "EliminarCategoriaCliente":
                        EliminarCategoriaCliente(request, response);
                        break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    protected void GuardarCategoriaCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        CategoriaCliente catCli = new CategoriaCliente();
        MetodosCategoriaCliente mCatCli = new MetodosCategoriaCliente();
        catCli.setCatClie(request.getParameter("txtCategoriaCliente").toUpperCase());
        if(request.getParameter("txtCategoriaCliente")!=null){
            try {
                 mCatCli.GuardarCategoriaCliente(catCli);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    protected void ModificarCategoriaCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        CategoriaCliente catCli = new CategoriaCliente();
        MetodosCategoriaCliente mCatCli = new MetodosCategoriaCliente();
        catCli.setCodigoCatCli(Integer.parseInt(request.getParameter("txtIDCatCli")));
        catCli.setCatClie(request.getParameter("txtCategoriaCliente").toUpperCase());
        if(request.getParameter("txtIDCatCli")!=null){
            try {
                 mCatCli.ModificarCategoriaCliente(catCli);
            } catch (Exception e) {
            }
        }
    }
    
    protected void EliminarCategoriaCliente(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        CategoriaCliente catCli = new CategoriaCliente();
        MetodosCategoriaCliente mCatCli = new MetodosCategoriaCliente();
        catCli.setCodigoCatCli(Integer.parseInt(request.getParameter("txtIDCatCli")));
        if(request.getParameter("txtIDCatCli")!=null){
            try {
                 mCatCli.EliminarCategoriaCliente(catCli);
            } catch (Exception e) {
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
