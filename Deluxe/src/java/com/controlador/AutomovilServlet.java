/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;


import com.modelo.Automovil;
import com.modelo.MetodosAutomoviles;
import com.modelo.MetodosCategoria;
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
public class AutomovilServlet extends HttpServlet {

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
                 case "Modificar":
                     Modificar(request, response);
                     break;
                 case "Eliminar":
                     Eliminar(request, response);
                     break;
             }
         }
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
    protected void Guardar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
        Automovil obj = new Automovil();
        MetodosAutomoviles MC = new MetodosAutomoviles();
        obj.setCodigo_Motor(request.getParameter("TxtMotor").toUpperCase());
        obj.setEspecificacion(Integer.parseInt(request.getParameter("TxtEspecificacion")));
        obj.setColor(Integer.parseInt(request.getParameter("TxtColor")));
        obj.setVersion(request.getParameter("TxtVersion").toUpperCase());
        obj.setTransmision(request.getParameter("TxtTransimision").toUpperCase());
        obj.setPrecio(Double.parseDouble(request.getParameter("TxtPrecio")));
        obj.setEstado("DISPONIBLE");
        
        if(request.getParameter("TxtMotor")!=null){
            try {
                 MC.GuardarAutomovil(obj);
                 
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
           
        }
       
    }

    protected void Modificar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
        Automovil obj = new Automovil();
        MetodosAutomoviles MC = new MetodosAutomoviles();
        obj.setCodigo_Motor(request.getParameter("TxtMotor").toUpperCase());
        obj.setEspecificacion(Integer.parseInt(request.getParameter("TxtEspecificacion")));
        obj.setColor(Integer.parseInt(request.getParameter("TxtColor")));
        obj.setVersion(request.getParameter("TxtVersion").toUpperCase());
        obj.setTransmision(request.getParameter("TxtTransimision").toUpperCase());
        obj.setPrecio(Double.parseDouble(request.getParameter("TxtPrecio")));
        
        if(request.getParameter("TxtMotor")!=null){
            try {
                 MC.ModificarAutomovil(obj);
                 
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
           
        }
        

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Automovil obj = new Automovil();
        MetodosAutomoviles MC = new MetodosAutomoviles();
        obj.setCodigo_Motor(request.getParameter("TxtMotor").toUpperCase());      
        if(request.getParameter("TxtMotor")!=null){
            try {
                 MC.EliminarAutomovil(obj);
                 
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
